package com.solvd.essay.persistence.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private static String url;
    private static String username;
    private static String password;
    private static final int CONNECTION_POOL_NUMBER=5;

    private static List<Connection> connectionPoolList;
    private static List<Connection> usedConnectionPoolList;

    private static Properties properties;

    static {
        properties=new Properties();
        try(FileInputStream fileInputStream=new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
        try {
            for (int i = 0; i < CONNECTION_POOL_NUMBER; i++) {
                Connection conn =createNewConnection();
                connectionPoolList.add(conn);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection createNewConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static synchronized boolean releaseConnection(Connection conn){

        if (usedConnectionPoolList.remove(conn)){
            connectionPoolList.add(conn);
            return true;
        };
        return false;
    }

    public static synchronized Connection getConnection(){
        if (connectionPoolList.isEmpty()){
            throw new RuntimeException();
        }
        Connection conn= connectionPoolList.remove(connectionPoolList.size()-1);
        usedConnectionPoolList.add(conn);
        return conn;

    }

}
