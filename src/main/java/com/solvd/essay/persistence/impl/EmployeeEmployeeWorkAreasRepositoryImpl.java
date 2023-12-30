package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.EmployeeEmployeeWorkAreas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeEmployeeWorkAreasRepositoryImpl extends AbstracDao<EmployeeEmployeeWorkAreas>{
    public EmployeeEmployeeWorkAreasRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(EmployeeEmployeeWorkAreas newThingToUpdate) {
        String updateQuery=String.format("update %s set employee_id= %s,employee_work_area_id= %s where id=%s"
                ,getTableName(),newThingToUpdate.getEmployeeId(),
                newThingToUpdate.getEmployeeworkAreaId(),newThingToUpdate.getId());
        return updateQuery;
    }

    @Override
    protected String getTableName() {
        return "employee_employee_work_areas";
    }

    @Override
    protected String getTableFields() {
        return "employee_id,employee_work_area_id";
    }

    @Override
    protected Long getThingId(EmployeeEmployeeWorkAreas thing) {
        return thing.getId();
    }

    @Override
    protected EmployeeEmployeeWorkAreas mapResultToObject(ResultSet resultSet, Connection conn) throws SQLException {
        EmployeeEmployeeWorkAreas entity= new EmployeeEmployeeWorkAreas();
        entity.setId(resultSet.getLong("id"));
        entity.setEmployeeId(resultSet.getLong("employee_id"));
        entity.setEmployeeworkAreaId(resultSet.getLong("employee_work_area_id"));
        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, EmployeeEmployeeWorkAreas thingToCreate) {
        try {
            ps.setLong(1,thingToCreate.getEmployeeId());
            ps.setLong(2,thingToCreate.getEmployeeworkAreaId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
