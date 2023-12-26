package com.solvd.essay.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BatchInfoRepositoryImpl extends AbstracDao {
    public BatchInfoRepositoryImpl(Connection conn) {
        super(conn);
    }

    @Override
    protected String getUpdateQuery(Object newThingToUpdate) {
        return null;
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected String getTableFields() {
        return null;
    }

    @Override
    protected String getThingFields(Object thing) {
        return null;
    }

    @Override
    protected Long getThingId(Object thing) {
        return null;
    }

    @Override
    protected Object mapResultToObject(ResultSet resultSet) throws SQLException {
        return null;
    }
}
