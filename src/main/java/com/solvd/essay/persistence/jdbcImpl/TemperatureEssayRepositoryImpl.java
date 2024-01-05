package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.domain.TemperatureEssay;
import com.solvd.essay.service.LabTestReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TemperatureEssayRepositoryImpl extends AbstracDao<TemperatureEssay> {
    private static final Logger LOGGER = LogManager.getLogger(TemperatureEssayRepositoryImpl.class);

    public TemperatureEssayRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(TemperatureEssay newThingToUpdate,Long id) {
        try{
            String updateQuery=String.format("update %s set front_measurement=%s ,essay_result=%s,lab_test_report_id=%s,left_side_measurement=%s where id=%s",
                    getTableName(),newThingToUpdate.getFrontMeasurement(),newThingToUpdate.getEssayResult(),newThingToUpdate.getLabTestReport().getId(),
                    newThingToUpdate.getLeftSideMeasurement(),id);
            return updateQuery;
        }catch (NullPointerException e){
            LOGGER.info("The update can't be null in any field");
            return "invalid update";
        }
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
        //entity.setLabTestReportId(resultSet.getLong("lab_test_report_id"));
        LabTestReportService newLabTestReportService= new LabTestReportService();
        entity.setLabTestReport(newLabTestReportService.findOne(resultSet.getLong("lab_test_report_id")));
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
            ps.setLong(3,thingToCreate.getLabTestReport().getId());
            ps.setDouble(4,thingToCreate.getLeftSideMeasurement());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected TemperatureEssay returnVoidInstance() {
        return new TemperatureEssay();
    }

    @Override
    protected void saveListInObject(TemperatureEssay thing, List<TemperatureEssay> list) {
        thing.setTemperatureEssayList(list);
    }
}
