package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.domain.EssayModule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BatchInfoRepositoryImpl extends AbstracDao<BatchInfo> {
    public BatchInfoRepositoryImpl(Connection conn) {
        super(conn);
    }

    @Override
    protected String getUpdateQuery(BatchInfo newThingToUpdate) {
        return null;
    }

    @Override
    protected String getTableName() {
        return "batch_info";
    }

    @Override
    protected String getTableFields() {
        return "batch_number";
    }

    @Override
    protected String getThingFields(BatchInfo thing) {
        return thing.getBatchNumber();
    }

    @Override
    protected Long getThingId(BatchInfo thing) {
        return thing.getId();
    }

    @Override
    protected BatchInfo mapResultToObject(ResultSet resultSet) throws SQLException {
        BatchInfo entity= new BatchInfo();
        entity.setId(resultSet.getLong("id"));
        entity.setBatchNumber(resultSet.getString("batch_number"));
        return entity;
    }
}
