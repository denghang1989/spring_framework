package com.dhcc.cn.framework.enums;

/**
 * 配置多数据源
 */
public enum DBTypeEnum {

    MYSQL("mysql"), CACHE("cache");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}