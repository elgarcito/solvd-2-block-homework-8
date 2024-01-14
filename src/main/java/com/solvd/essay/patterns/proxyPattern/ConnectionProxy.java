package com.solvd.essay.patterns.proxyPattern;

import com.solvd.essay.persistence.ConnectionPool;


import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProxy {
    private Connection connection;
    private final ConnectionPool pool;

    public ConnectionProxy(ConnectionPool pool) {
        this.pool = pool;
    }

    public Connection connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = ConnectionPool.getConnection();
        }
        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            ConnectionPool.releaseConnection(connection);
            connection = null;
        }
    }
}
