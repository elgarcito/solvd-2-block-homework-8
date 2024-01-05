package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.domain.BatchInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BatchInfoRepositoryImpl extends AbstracDao<BatchInfo> {
    public BatchInfoRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(BatchInfo newThingToUpdate,Long id) {
        String updateQuery=String.format("update batch_info set batch_Number=\"%s\" where id=%s"
                ,newThingToUpdate.getBatchNumber(),id);
        return updateQuery;
    }



    @Override
    protected String getTableName() {
        return "batch_info";
    }

    @Override
    protected String getTableFields() {
        return "batch_number";
    }

    /*
    @Override
    protected String getThingFields(BatchInfo thing) {
        return thing.getBatchNumber();
    }

     */

    @Override
    protected Long getThingId(BatchInfo thing) {
        return thing.getId();
    }

    @Override
    protected BatchInfo mapResultToObject(ResultSet resultSet, Connection conn) throws SQLException {
        BatchInfo entity= new BatchInfo();
        entity.setId(resultSet.getLong("id"));
        entity.setBatchNumber(resultSet.getString("batch_number"));
        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?)",getTableName(),getTableFields());
        return createQuery;
    }


    @Override
    protected void setQueryStatements(PreparedStatement ps, BatchInfo thingToCreate) {
        try {
            ps.setString(1,thingToCreate.getBatchNumber());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected BatchInfo returnVoidInstance() {
        return new BatchInfo();
    }

    @Override
    protected void saveListInObject(BatchInfo thing, List<BatchInfo> list) {
        thing.setMyBatchInfoList(list);
    }
}
