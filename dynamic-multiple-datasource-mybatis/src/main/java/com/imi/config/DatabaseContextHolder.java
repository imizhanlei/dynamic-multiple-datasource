package com.imi.config;

/**
 * Created by mi on 2018/5/24.
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static DatabaseType getDatabaseType(){
        return contextHolder.get();
    }

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }
}
