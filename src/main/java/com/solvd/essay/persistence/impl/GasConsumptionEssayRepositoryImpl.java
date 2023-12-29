package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.GasConsumptionEssay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GasConsumptionEssayRepositoryImpl extends AbstracDao<GasConsumptionEssay>{
    public GasConsumptionEssayRepositoryImpl(Connection conn) {
        super(conn);
    }

    @Override
    protected String getUpdateQuery(GasConsumptionEssay newThingToUpdate) {
        String updateQuery= String.format("update gas_consumption_essay set max_consume=%s,standard_mean=%s,measurement_error=%s,essay_result=%s,lab_test_report_id=%s where id=%s",
                newThingToUpdate.getMaxConsume(),newThingToUpdate.getStandardMean(),newThingToUpdate.getMeasurementError(),
                newThingToUpdate.getEssayResult(),newThingToUpdate.getLabTestReportId(),newThingToUpdate.getId());
        return updateQuery;
    }

    @Override
    protected String getTableName() {
        return "gas_consumption_essay";
    }

    @Override
    protected String getTableFields() {
        return "max_consume,standard_mean,measurement_error,essay_result,lab_test_report_id";
    }

    @Override
    protected Long getThingId(GasConsumptionEssay thing) {
        return thing.getId();
    }

    @Override
    protected GasConsumptionEssay mapResultToObject(ResultSet resultSet, Connection conn) throws SQLException {
        GasConsumptionEssay entity=new GasConsumptionEssay();
        entity.setId(resultSet.getLong("id"));
        entity.setMaxConsume(resultSet.getDouble("max_consume"));
        entity.setStandardMean(resultSet.getDouble("standard_mean"));
        entity.setMeasurementError(resultSet.getDouble("measurement_error"));
        entity.setEssayResult(resultSet.getBoolean("essay_result"));
        entity.setLabTestReportId(resultSet.getLong("lab_test_report_id"));
        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?,?,?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, GasConsumptionEssay thingToCreate) {
        try {
            ps.setDouble(1,thingToCreate.getMaxConsume());
            ps.setDouble(2,thingToCreate.getStandardMean());
            ps.setDouble(3,thingToCreate.getMeasurementError());
            ps.setBoolean(4,thingToCreate.getEssayResult());
            ps.setLong(5,thingToCreate.getLabTestReportId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}