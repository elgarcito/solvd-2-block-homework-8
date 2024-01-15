package com.solvd.essay.patterns.strategyPattern;

import com.solvd.essay.patterns.proxyPattern.ConnectionProxy;
import com.solvd.essay.persistence.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindBatchWithDirectQuery implements StrategyBatch {
    private static final Logger LOGGER = LogManager.getLogger(FindBatchWithDirectQuery.class);
    @Override
    public String findBatchById(Long id) {
        ConnectionPool connectionPool=new ConnectionPool();
        ConnectionProxy connectionProxy= new ConnectionProxy(connectionPool);
        try (Connection connection = connectionProxy.connect()) {
            PreparedStatement ps=connection.prepareStatement("select * from batch_info where id=?");
            ps.setLong(1,id);
            ResultSet resultSet= ps.executeQuery();
            resultSet.next();
            LOGGER.info("Batch number obtained using a direct consult");
           return resultSet.getString("batch_number");
        }catch (SQLException e){
            LOGGER.info(e.getMessage());
            return null;
        }
    }
}
