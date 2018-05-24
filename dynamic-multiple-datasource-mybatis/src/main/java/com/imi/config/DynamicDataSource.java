package com.imi.config;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by mi on 2018/5/24.
 * 动态数据源（需要继承AbstractRoutingDataSource）
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }
}
