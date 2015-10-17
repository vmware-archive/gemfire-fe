/*
 * jcollectd
 * Copyright (C) 2009 Hyperic, Inc.
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; only version 2 of the License is applicable.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 */

package org.jcollectd.agent.mx;

import org.jcollectd.agent.api.DataSource;
import org.jcollectd.agent.api.Identifier;
import org.jcollectd.agent.api.Values;
import org.jcollectd.agent.protocol.Network;

import javax.management.*;
import javax.management.openmbean.CompositeData;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Query MBeans and dispatch results upstream.
 */
public class MBeanCollector implements Runnable {

    private static final Logger _log =
            Logger.getLogger(MBeanCollector.class.getName());
    private static boolean _useDescriptors =
            "true".equals(Network.getProperty("mx.descriptors", "true"));
    private static Method _getDescriptor;
    private static final String _metricTypeField =
            Network.getProperty("mx.metricTypeField", "metricType");
    private MBeanSender _sender;
    private long _interval = 60;
    private final Map<String, MBeanQuery> _queries =
            new HashMap<String, MBeanQuery>();

    static {
        if (_useDescriptors) {
            try {
                _getDescriptor = //1.6+
                        MBeanAttributeInfo.class.getMethod("getDescriptor",
                                (Class[]) null);
            } catch (Exception e) {
                _useDescriptors = false;
            }
        }
    }

    public MBeanSender getSender() {
        return _sender;
    }

    public void setSender(MBeanSender sender) {
        _sender = sender;
    }

    public long getInterval() {
        return _interval;
    }

    public void setInterval(long interval) {
        _interval = interval;
    }

    public Map<String, MBeanQuery> getQueries() {
        return _queries;
    }

    public MBeanQuery addMBean(String objectName) {
        MBeanQuery query = _queries.get(objectName);
        if (query == null) {
            try {
                query = new MBeanQuery(new ObjectName(objectName));
            } catch (Exception e) {
                throw new IllegalArgumentException(objectName);
            }
            _queries.put(objectName, query);
        }
        return query;
    }

    public MBeanAttribute addMBeanAttribute(String objectName,
                                            String attributeName) {
        MBeanQuery query = addMBean(objectName);
        if (attributeName != null) {
            MBeanAttribute attr = new MBeanAttribute(attributeName);
            query.addAttribute(attr);
            return attr;
        } else {
            return null;
        }
    }

    private boolean isNumber(Object obj) {
        if (obj == null) {
            return false;
        }
        return Number.class.isAssignableFrom(obj.getClass());
    }

    private String getBeanName(ObjectName query, ObjectName name) {
        Map<String, String> skip;
        if (query == null) {
            skip = new HashMap<String, String>();
        } else {
            skip = query.getKeyPropertyList();
        }
        StringBuilder iname = new StringBuilder();
        for (Object key : name.getKeyPropertyList().keySet()) {
            if (skip.get(key) != null) {
                continue;
            }
            if (iname.length() > 0) {
                iname.append(' ');
            }
            iname.append(name.getKeyProperty((String) key));
        }
        return iname.toString();
    }

    private void dispatch(MBeanQuery query, String plugin,
                          String typeInstance,
                          ObjectName name, MBeanAttribute attr,
                          Number val) {
        if (DataSource.Type.GAUGE.equals(attr.getDataType())) {
            val = val.doubleValue();
        } else {
            val = val.longValue();
        }

        String pluginInstance = query.getPluginInstance();
        if (pluginInstance == null) {
            pluginInstance = _sender.getInstanceName();
        }
        String beanName = query.getAlias();
        Identifier.Builder builder = Identifier.Builder.builder();
        builder.plugin(plugin);
        if (beanName == null) {
            beanName = getBeanName(null, name);
        } else if (query.getName().isPattern()) {
            String instName = getBeanName(query.getName(), name);
            if (instName != null) {
                beanName += " " + instName;
            }
        }
        builder.pluginInstance(pluginInstance + "-" + beanName);
        builder.type(attr.getTypeName());
        builder.typeInstance(typeInstance);
        Values values = new Values(builder.build());
        values.addValue(val);
        values.setInterval(getInterval());
        _sender.dispatch(values);
    }

    void collect(MBeanQuery query, ObjectName name) throws Exception {
        MBeanServerConnection conn = _sender.getMBeanServerConnection();
        String plugin = query.getPlugin();
        if (plugin == null) {
            plugin = name.getDomain();
        }

        Map<String, MBeanAttributeInfo> attrInfo = null;
        if (_useDescriptors) {
            MBeanInfo info = conn.getMBeanInfo(name);
            attrInfo = new HashMap<String, MBeanAttributeInfo>();
            for (MBeanAttributeInfo ainfo : info.getAttributes()) {
                attrInfo.put(ainfo.getName(), ainfo);
            }
        }

        for (MBeanAttribute attr : query.getAttributes()) {
            String attrName = attr.getAttributeName();
            Object obj;

            try {
                obj = conn.getAttribute(name, attrName);
            } catch (Exception e) {
                //XXX remove attr for future collection e.g. UnsupportedOperation
                continue;
            }

            if (_useDescriptors) {
                //e.g. spring @ManagedMetric(metricType = MetricType.COUNTER)
                try {
                    Descriptor descriptor =
                            (Descriptor) _getDescriptor.invoke(attrInfo.get(attrName),
                                    (Object[]) null);
                    Object type = descriptor.getFieldValue(_metricTypeField);
                    if (DataSource.Type.COUNTER.name().equals(type)) {
                        if (attr.getTypeName().equals(DataSource.Type.GAUGE.name())) {
                            attr.setTypeName(DataSource.Type.COUNTER.name());
                        }
                        attr.setDataType(DataSource.Type.COUNTER.value());
                    }
                } catch (Exception e) {
                }
            }

            if (obj instanceof CompositeData) {
                CompositeData data = (CompositeData) obj;
                String key = attr.getCompositeKey();
                if (key == null) {
                    //no key specified; collect all
                    Set<String> keys = data.getCompositeType().keySet();
                    for (String ckey : keys) {
                        obj = data.get(ckey);
                        if (!isNumber(obj)) {
                            continue;
                        }
                        dispatch(query, plugin,
                                attrName + "." + ckey,
                                name, attr, (Number) obj);
                    }
                    continue;
                } else {
                    obj = data.get(key);
                }
            }
            if (!isNumber(obj)) {
                continue;
            }
            dispatch(query, plugin,
                    attr.getName(),
                    name, attr, (Number) obj);
        }
        _sender.flush();
    }

    private void run(MBeanQuery query, ObjectName name) {
        try {
            if (query.getAttributes().size() == 0) {
                query = queryAll(name);
            }
            collect(query, name);
        } catch (Exception e) {
            //MBean might not be registered yet
            _log.log(Level.FINE, "collect " + name, e);
        }
    }

    private MBeanQuery queryAll(ObjectName name)
            throws Exception {
        MBeanQuery query = new MBeanQuery(name);
        MBeanInfo info = _sender.getMBeanServerConnection().getMBeanInfo(name);
        MBeanAttributeInfo[] attrs = info.getAttributes();
        for (MBeanAttributeInfo attr : attrs) {
            query.addAttribute(new MBeanAttribute(attr.getName()));
        }
        return query;
    }

    public void run() {
        for (MBeanQuery query : _queries.values()) {
            ObjectName name = query.getName();
            if (name.isPattern()) {
                Set<ObjectName> beans;
                try {
                    beans =
                            _sender.getMBeanServerConnection().queryNames(name, null);
                } catch (Exception e) {
                    _log.warning("queryNames(" + name + "): " + e);
                    return;
                }
                for (ObjectName oname : beans) {
                    run(query, oname);
                }
            } else {
                run(query, name);
            }
        }
    }
}
