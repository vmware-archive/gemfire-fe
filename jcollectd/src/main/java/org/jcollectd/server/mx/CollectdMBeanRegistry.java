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

package org.jcollectd.server.mx;

import org.jcollectd.agent.api.*;
import org.jcollectd.agent.api.Notification;
import org.jcollectd.agent.protocol.Dispatcher;
import org.jcollectd.agent.protocol.Network;
import org.jcollectd.agent.protocol.TypesDB;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Convert collectd value_list_t structures to JMX MBeans.
 * collectd notifications are broadcast as JMX notifications.
 */
public class CollectdMBeanRegistry
        implements Dispatcher, NotificationBroadcaster, CollectdMBeanRegistryMBean {

    private String DOMAIN = "collectd";
    final static String STATUS = "__status__";
    final static String AVERAGE = "__avg__";
    final static String SUM = "__sum__";

    private final Map<ObjectName, Map<String, Number>> beans =
            new HashMap<ObjectName, Map<String, Number>>();
    private final NotificationBroadcasterSupport _broadcaster =
            new NotificationBroadcasterSupport();
    private static final Pattern _hosts = hostPattern();

    private long _notifSequence = 0;
    private final boolean _doSummary = "true".equals(Network.getProperty("mx.summary"));
    private final boolean _doPluginSummary = "true".equals(Network.getProperty("mx.pluginsummary"));


    final MBeanServer bs =
            ManagementFactory.getPlatformMBeanServer();

    public CollectdMBeanRegistry(String jcd) {
        DOMAIN = jcd;
    }

    public void init() throws Exception {
        ObjectName name = new ObjectName(DOMAIN + ":" + "type=" + "MBeanRegistry");
        bs.registerMBean(this, name);
    }

    private static Pattern hostPattern() {
        String hosts = Network.getProperty("mx.hosts");
        if (hosts == null) {
            return null;
        }
        return Pattern.compile(hosts);
    }

    private static boolean excludeHost(Identifier data) {
        if (_hosts == null) {
            return false;
        }
        return !_hosts.matcher(data.getHost()).find();
    }

    public void dispatch(Notification notif) {
        if (excludeHost(notif)) {
            return;
        }
        _broadcaster.sendNotification(new javax.management.
                Notification(notif.getSeverity().name(),
                notif.getSource(),
                ++_notifSequence,
                notif.getTime(),
                notif.getMessage()));
    }

    private String getRootName(String host, Values vals) {
        StringBuilder name = new StringBuilder();
        name.append(DOMAIN).append(':');
        if (host != null) {
            name.append("host=").append(host).append(',');
        }
        name.append("plugin=").append(vals.getPlugin());
        if (host == null) {
            name.append(",*");
        }
        return name.toString();
    }

    private String getPluginRootName(String pname, Values vals) {
        StringBuilder name = new StringBuilder();
        name.append(DOMAIN).append(':');
        name.append("host=").append(vals.getHost()).append(',');
        name.append("plugin=").append(vals.getPlugin()).append(',');
        name.append("name=");

        if (pname != null) {
            name.append(pname);
        } else {
            name.append("*");
        }

        return name.toString();
    }

    Map<String, Number> getMBean(ObjectName name) {
        return beans.get(name);
    }

    Number getMBeanAttribute(ObjectName name, String attribute) {
        Map<String, Number> bean = getMBean(name);
        if (bean == null) {
            return null;
        }
        return bean.get(attribute);
    }

    private Map<String, Number> getMBean(Values vals) {
        String instance = vals.getPluginInstance();

        StringBuilder bname = new StringBuilder();
        bname.append(getRootName(vals.getHost(), vals));
        if (!vals.defined(instance)) {
            List<DataSource> ds = vals.getDataSource();
            if (ds == null) {
                ds = TypesDB.getInstance().getType(vals.getType());
            }
            if ((ds != null) && (ds.size() > 1)) {
                //e.g. ds = {rx,tx} -> type=if_octets,typeInstance=en1 
                instance = vals.getTypeInstance();
            }
        }
        if (vals.defined(instance)) {
            bname.append(',').append("name=").append(instance);
        }

        ObjectName name;
        try {
            name = new ObjectName(bname.toString());
        } catch (MalformedObjectNameException e) {
            throw new IllegalArgumentException(bname + ": " + e);
        }

        Map<String, Number> metrics = getMBean(name);
        if (metrics != null) {
            return metrics;
        }

        metrics = new HashMap<String, Number>();
        beans.put(name, metrics);

        try {
            bs.registerMBean(new CollectdMBean(metrics), name);

            if (_doSummary) {
                registerSummaryMBean(vals, metrics);
            }

            if (_doPluginSummary) {
                if (instance != null && !instance.isEmpty()) {
                    registerPluginSummaryMBean(vals, metrics);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return metrics;
    }

    private void registerSummaryMBean(Values vl, Map<String, Number> metrics) throws MalformedObjectNameException, MBeanRegistrationException, InstanceAlreadyExistsException, NotCompliantMBeanException {
        ObjectName sname =
                new ObjectName(getRootName(AVERAGE, vl));
        if (!bs.isRegistered(sname)) {
            registerMbean(metrics, sname, new ObjectName(getRootName(null, vl)));
        }
    }

    private CollectdSummaryMBean registerPluginSummaryMBean(Values vl, Map<String, Number> metrics) throws MalformedObjectNameException, MBeanRegistrationException, InstanceAlreadyExistsException, NotCompliantMBeanException {
        ObjectName sname =
                new ObjectName(getPluginRootName(AVERAGE, vl));
        if (!bs.isRegistered(sname)) {
            return registerMbean(metrics, sname, new ObjectName(getPluginRootName(null, vl)));
        }
        return null;
    }

    private CollectdSummaryMBean registerMbean(Map<String, Number> metrics, ObjectName sname, ObjectName query) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        CollectdSummaryMBean summary =
                new CollectdSummaryMBean(query, metrics);
        summary.setMBeanRegistry(this);
        bs.registerMBean(summary, sname);
        return summary;
    }

    public void dispatch(Values vals) {
        if (excludeHost(vals)) {
            return;
        }
        String type = vals.getType();
        List<Number> values = vals.getData();
        int size = values.size();
        Map<String, Number> metrics = getMBean(vals);
        String key;

        if (size == 1) {
            String ti = vals.getTypeInstance();
            if (vals.defined(ti)) {
                key = type + "." + ti;
            } else {
                key = type;
            }
            metrics.put(key, values.get(0));

        } else {
            List<DataSource> ds = vals.getDataSource();
            if (ds == null) {
                ds = TypesDB.getInstance().getType(vals.getType());
            }
            for (int i = 0; i < size; i++) {
                if (ds != null && ds.size() > i) {
                    key = type + "." + ds.get(i).getName();
                } else {
                    key = type + "." + "unknown" + i;
                }
                metrics.put(key, values.get(i));
            }
        }
    }

    public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter,
                                        Object handback) {
        _broadcaster.addNotificationListener(listener, filter, handback);
    }

    public MBeanNotificationInfo[] getNotificationInfo() {
        return new MBeanNotificationInfo[]{
                new MBeanNotificationInfo(Notification.Severity.names(),
                        javax.management.Notification.class.getName(),
                        "Collectd Notifications"),
        };
    }

    public void removeNotificationListener(NotificationListener listener)
            throws ListenerNotFoundException {
        _broadcaster.removeNotificationListener(listener);
    }
}
