package com.solvd.essay.persistence;

;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private static String url;
    private static String userName;
    private static String password;
    private static Properties properties;
    private static final int POOL_SIZE=6;
    private static final List<Connection> usedConnections=new ArrayList<>();
    private static final List<Connection> connectionPool=new ArrayList<>();

    static {
        properties =new Properties();
        try(FileInputStream file=new FileInputStream("src/main/resources/config.properties")){
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        url= properties.getProperty("url");
        userName= properties.getProperty("username");
        password=properties.getProperty("password");
        try {
            for (int i=0;i<POOL_SIZE;i++){
                Connection conn =createNewConnection();
                connectionPool.add(conn);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection createNewConnection() throws SQLException {
        return  DriverManager.getConnection(url,userName,password);
    }

    public synchronized static boolean releaseConnection(Connection conn){
        if(usedConnections.remove(conn)){
            connectionPool.add(conn);
            return true;
        }
        return false;
    }

    public synchronized static Connection getConnection() throws SQLException{
        if(connectionPool.isEmpty()){
            throw new SQLException();
        }
        Connection retrievedConnection= connectionPool.remove(connectionPool.size()-1);
        usedConnections.add(retrievedConnection);
        return retrievedConnection;
    }


}
