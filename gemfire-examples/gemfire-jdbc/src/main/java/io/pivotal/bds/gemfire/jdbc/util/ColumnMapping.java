package io.pivotal.bds.gemfire.jdbc.util;

public class ColumnMapping {

    private String columnName;
    private String fieldName;
    private int columnType;
    private int columnSize;
    private Class<?> fieldType;

    public ColumnMapping() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public Class<?> getFieldType() {
        return fieldType;
    }

    public void setFieldType(Class<?> fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public String toString() {
        return "ColumnMapping [columnName=" + columnName + ", fieldName=" + fieldName + ", columnType=" + columnType
                + ", columnSize=" + columnSize + ", fieldType=" + fieldType + "]";
    }

}
