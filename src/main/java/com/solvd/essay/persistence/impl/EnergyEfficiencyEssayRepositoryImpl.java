package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.EnergyEfficiencyEssay;
import com.solvd.essay.domain.LabTestReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnergyEfficiencyEssayRepositoryImpl extends AbstracDao<EnergyEfficiencyEssay> {

    public EnergyEfficiencyEssayRepositoryImpl(Connection conn) {
        super(conn);
    }

    @Override
    protected String getUpdateQuery(EnergyEfficiencyEssay newThingToUpdate) {
        String updateQuery=String.format("update energy_efficiency_essay set value_of_essay=%s,category=\"%s\",essay_result=%s,lab_test_report_id=%s where id= %s",
                newThingToUpdate.getValueOfEssay(),newThingToUpdate.getCategory(),newThingToUpdate.essayResult(),newThingToUpdate.getLabTestReportId(),newThingToUpdate.getId());
        return updateQuery;
    }

    @Override
    protected String getTableName() {
        return "energy_efficiency_essay";
    }

    @Override
    protected String getTableFields() {
        return "value_of_essay,category,essay_result,lab_test_report_id";
    }

    @Override
    protected Long getThingId(EnergyEfficiencyEssay thing) {
        return thing.getId();
    }

    @Override
    protected EnergyEfficiencyEssay mapResultToObject(ResultSet resultSet,Connection conn) throws SQLException {
        EnergyEfficiencyEssay entity=new EnergyEfficiencyEssay();
        entity.setId(resultSet.getLong("id"));
        entity.setValueOfEssay(resultSet.getDouble("value_of_essay"));
        entity.setCategory(resultSet.getString("category"));
        entity.setEssayResult(resultSet.getBoolean("essay_result"));
        entity.setLabTestReportId(resultSet.getLong("lab_test_report_id"));
        return  entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?,?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, EnergyEfficiencyEssay thingToCreate) {
        try {
            ps.setDouble(1,thingToCreate.getValueOfEssay());
            ps.setString(2,thingToCreate.getCategory());
            ps.setBoolean(3,thingToCreate.getEssayResult());
            ps.setLong(4,thingToCreate.getLabTestReportId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
