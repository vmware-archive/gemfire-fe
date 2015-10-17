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
import org.jcollectd.agent.protocol.TypesDB;

import java.util.List;

/**
 * MBean attribute to collectd metric metadata mapper.
 */
public class MBeanAttribute {

    private static final TypesDB _types = TypesDB.getInstance();
    private String _name;
    private String _attributeName;
    private String _compositeKey;
    private String _typeName;
    private int _dataType;

    public MBeanAttribute(String attributeName) {
        this(attributeName, DataSource.Type.GAUGE.value());
    }

    private MBeanAttribute(String attributeName, int dataType) {
        this(attributeName, dataType, null);
    }

    private static int getDataType(String typeName) {
        List<DataSource> ds = _types.getType(typeName);
        if ((ds == null) || (ds.size() == 0)) {
            return DataSource.Type.GAUGE.value();
        } else {
            return ds.get(0).getType();
        }
    }

    public MBeanAttribute(String attributeName, String typeName) {
        this(attributeName, getDataType(typeName), typeName);
    }

    private MBeanAttribute(String attributeName, int dataType, String typeName) {
        _name = attributeName;
        _dataType = dataType;
        _typeName = typeName;
        if (_typeName == null) {
            if (dataType == DataSource.Type.COUNTER.value()) {
                _typeName = DataSource.Type.COUNTER.name();
            } else {
                _typeName = DataSource.Type.GAUGE.name().toLowerCase();
            }
        }
        int ix = attributeName.indexOf('.');
        if (ix != -1) {
            _attributeName = attributeName.substring(0, ix);
            _compositeKey = attributeName.substring(ix + 1);
        } else {
            _attributeName = attributeName;
        }
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getAttributeName() {
        return _attributeName;
    }

    public void setAttributeName(String attributeName) {
        _attributeName = attributeName;
    }

    public String getCompositeKey() {
        return _compositeKey;
    }

    public void setCompositeKey(String compositeKey) {
        _compositeKey = compositeKey;
    }

    public String getTypeName() {
        return _typeName;
    }

    public void setTypeName(String typeName) {
        _typeName = typeName;
    }

    public int getDataType() {
        return _dataType;
    }

    public void setDataType(int dataType) {
        _dataType = dataType;
    }
}
