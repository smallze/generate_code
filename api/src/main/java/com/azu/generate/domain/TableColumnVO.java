package com.azu.generate.domain;

/**
 * @author zzs
 * @date 2021/7/18 12:04
 */
public class TableColumnVO {

    private String columnName;

    private Boolean isRequired;

    private Boolean isPk;

    private Integer sort;

    private String columnComment;

    private Boolean isIncrement;

    private String columnType;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public Boolean getPk() {
        return isPk;
    }

    public void setPk(Boolean pk) {
        isPk = pk;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public Boolean getIncrement() {
        return isIncrement;
    }

    public void setIncrement(Boolean increment) {
        isIncrement = increment;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
}
