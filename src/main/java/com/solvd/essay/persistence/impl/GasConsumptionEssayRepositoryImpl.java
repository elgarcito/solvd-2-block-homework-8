package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.GasConsumptionEssay;
import com.solvd.essay.domain.LabTestReport;
import com.solvd.essay.service.LabTestReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GasConsumptionEssayRepositoryImpl extends AbstracDao<GasConsumptionEssay>{
    public GasConsumptionEssayRepositoryImpl() {
    }

    private static final Logger LOGGER = LogManager.getLogger(GasConsumptionEssayRepositoryImpl.class);
    @Override
    protected String getUpdateQuery(GasConsumptionEssay newThingToUpdate,Long id) {
        try{
        String updateQuery= String.format("update gas_consumption_essay set max_consume=%s,standard_mean=%s,measurement_error=%s,essay_result=%s,lab_test_report_id=%s where id=%s",
                newThingToUpdate.getMaxConsume(),newThingToUpdate.getStandardMean(),newThingToUpdate.getMeasurementError(),
                newThingToUpdate.getEssayResult(),newThingToUpdate.getLabTestReport().getId(),id);
        return updateQuery;
    }catch (NullPointerException e){
        LOGGER.info("The update can't be null in any field");
        return "invalid update";
    }
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

        //entity.setLabTestReportId(resultSet.getLong("lab_test_report_id"));

        LabTestReportService newLabTestReportService= new LabTestReportService();
        entity.setLabTestReport(newLabTestReportService.findOne(resultSet.getLong("lab_test_report_id")));


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
            ps.setLong(5,thingToCreate.getLabTestReport().getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected GasConsumptionEssay returnVoidInstance() {
        return new GasConsumptionEssay();
    }
}