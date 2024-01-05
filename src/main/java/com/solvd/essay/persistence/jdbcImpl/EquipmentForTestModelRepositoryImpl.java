package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.domain.EquipmentForTestModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentForTestModelRepositoryImpl extends AbstracDao<EquipmentForTestModel>{
    public EquipmentForTestModelRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(EquipmentForTestModel newThingToUpdate,Long id) {
        String updateQuery=String.format("update %s set model_description=\"%s\",release_date=\"%s\" where id= %s",
                getTableName(),newThingToUpdate.getModelDescription(),
                newThingToUpdate.getReleaseDate(),id);
        return updateQuery;
    }

    @Override
    protected String getTableName() {
        return "equipment_for_test_model";
    }

    @Override
    protected String getTableFields() {
        return "model_name,model_description,release_date";
    }

    @Override
    protected Long getThingId(EquipmentForTestModel thing) {
        return thing.getId();
    }

    @Override
    protected EquipmentForTestModel mapResultToObject(ResultSet resultSet, Connection conn) throws SQLException {
        EquipmentForTestModel entity= new EquipmentForTestModel();
        entity.setId(resultSet.getLong("id"));
        entity.setModelName(resultSet.getString("model_name"));
        entity.setModelDescription(resultSet.getString("model_description"));
        entity.setReleaseDate(resultSet.getDate(  "release_date"));
        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, EquipmentForTestModel thingToCreate) {
        try {
            ps.setString(1,thingToCreate.getModelName());
            ps.setString(2,thingToCreate.getModelDescription());
            ps.setDate(3, thingToCreate.getReleaseDate());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected EquipmentForTestModel returnVoidInstance() {
        return new EquipmentForTestModel();
    }
}
