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

import javax.management.*;
import java.util.Map;

/**
 * Wrap a Map&lt;String,Number&gt; as a DynamicMBean.
 */
public class CollectdMBean implements DynamicMBean {

    private final Map<String, Number> _metrics;

    public CollectdMBean(Map<String, Number> metrics) {
        _metrics = metrics;
    }

    public Object getAttribute(String key)
            throws AttributeNotFoundException,
            MBeanException, ReflectionException {

        Number val = _metrics.get(key);
        if (val == null) {
            throw new AttributeNotFoundException(key);
        }
        return val;
    }

    public AttributeList getAttributes(String[] attrs) {
        AttributeList result = new AttributeList();
        for (String attr : attrs) {
            try {
                result.add(new Attribute(attr,
                        getAttribute(attr)));
            } catch (AttributeNotFoundException e) {
            } catch (MBeanException e) {
            } catch (ReflectionException e) {
            }
        }
        return result;
    }

    String getAttributeType(String name) {
        return _metrics.get(name).getClass().getName();
    }

    String getAttributeDescription(String name) {
        return name + " Attribute";
    }

    MBeanAttributeInfo[] getAttributeInfo() {
        MBeanAttributeInfo[] attrs =
                new MBeanAttributeInfo[_metrics.size()];
        int i = 0;
        for (String name : _metrics.keySet()) {
            attrs[i++] =
                    new MBeanAttributeInfo(name,
                            getAttributeType(name),
                            getAttributeDescription(name),
                            true,   // isReadable
                            false,  // isWritable
                            false); // isIs
        }
        return attrs;
    }

    public MBeanInfo getMBeanInfo() {
        return new MBeanInfo(getClass().getName(),
                CollectdMBean.class.getName(),
                getAttributeInfo(),
                null, //constructors
                null, //operations
                null);
    }

    public Object invoke(String arg0, Object[] arg1, String[] arg2)
            throws MBeanException, ReflectionException {
        // TODO Auto-generated method stub
        return null;
    }

    public void setAttribute(Attribute arg0)
            throws AttributeNotFoundException,
            InvalidAttributeValueException,
            MBeanException, ReflectionException {
        // TODO Auto-generated method stub
    }

    public AttributeList setAttributes(AttributeList arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}
