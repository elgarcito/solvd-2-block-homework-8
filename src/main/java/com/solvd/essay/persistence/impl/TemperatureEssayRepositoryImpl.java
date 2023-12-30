package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.GasConsumptionEssay;
import com.solvd.essay.domain.TemperatureEssay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TemperatureEssayRepositoryImpl extends AbstracDao<TemperatureEssay> {

    public TemperatureEssayRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(TemperatureEssay newThingToUpdate) {
        String updateQuery=String.format("update %s set front_measurement=%s ,essay_result=%s,lab_test_report_id=%s,left_side_measurement=%s where id=%s",
                getTableName(),newThingToUpdate.getFrontMeasurement(),newThingToUpdate.getEssayResult(),newThingToUpdate.getLabTestReportId(),
                newThingToUpdate.getLeftSideMeasurement(),newThingToUpdate.getId());
        return updateQuery;
    }

    @Override
    protected String getTableName() {
        return "temperature_essay";
    }

    @Override
    protected String getTableFields() {
        return "front_measurement,essay_result,lab_test_report_id,left_side_measurement";
    }

    @Override
    protected Long getThingId(TemperatureEssay thing) {
        return thing.getId();
    }

    @Override
    protected TemperatureEssay mapResultToObject(ResultSet resultSet, Connection conn) throws SQLException {
        TemperatureEssay entity=new TemperatureEssay();
        entity.setId(resultSet.getLong("id"));
        entity.setFrontMeasurement(resultSet.getDouble("front_measurement"));
        entity.setEssayResult(resultSet.getBoolean("essay_result"));
        entity.setLabTestReportId(resultSet.getLong("lab_test_report_id"));
        entity.setLeftSideMeasurement(resultSet.getDouble("left_side_measurement"));
        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?,?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, TemperatureEssay thingToCreate) {
        try {
            ps.setDouble(1,thingToCreate.getFrontMeasurement());
            ps.setBoolean(2,thingToCreate.getEssayResult());
            ps.setLong(3,thingToCreate.getLabTestReportId());
            ps.setDouble(4,thingToCreate.getLeftSideMeasurement());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
