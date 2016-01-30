package io.pivotal.bds.gemfire.jdbc.util;

import java.util.HashMap;
import java.util.Map;

public class TableMapping {

    private String tableName;
    private String regionName;
    private String keyColumnName;
    private Map<String, ColumnMapping> columnMappingsByColumn = new HashMap<>();
    private Map<String, ColumnMapping> columnMappingsByField = new HashMap<>();
    private ConnectionConfiguration connection;

    public TableMapping() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getKeyColumnName() {
        return keyColumnName;
    }

    public void setKeyColumnName(String keyColumnName) {
        this.keyColumnName = keyColumnName;
    }

    public Map<String, ColumnMapping> getColumnMappingsByColumn() {
        return columnMappingsByColumn;
    }

    public void setColumnMappingsByColumn(Map<String, ColumnMapping> columnMappingsByColumn) {
        this.columnMappingsByColumn = columnMappingsByColumn;
    }

    public Map<String, ColumnMapping> getColumnMappingsByField() {
        return columnMappingsByField;
    }

    public void setColumnMappingsByField(Map<String, ColumnMapping> columnMappingsByField) {
        this.columnMappingsByField = columnMappingsByField;
    }

    public ConnectionConfiguration getConnection() {
        return connection;
    }

    public void setConnection(ConnectionConfiguration connection) {
        this.connection = connection;
    }

    @Override
    public String toString() {
        return "TableMapping [tableName=" + tableName + ", regionName=" + regionName + ", keyColumnName=" + keyColumnName
                + ", columnMappingsByColumn=" + columnMappingsByColumn + ", columnMappingsByField=" + columnMappingsByField
                + ", connection=" + connection + "]";
    }

}
