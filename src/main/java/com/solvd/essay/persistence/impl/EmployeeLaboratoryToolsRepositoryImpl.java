package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.EmployeeLaboratoryTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeLaboratoryToolsRepositoryImpl extends AbstractDao<EmployeeLaboratoryTools> {
    public EmployeeLaboratoryToolsRepositoryImpl(Connection conn) {
        super(conn);
    }

    @Override
    protected String getUpdateQuery(EmployeeLaboratoryTools newThingToUpdate) {
        String updateQuery=String.format("update %s set employee_id= %s,laboratory_tool_id= %s where id=%s"
                ,getTableName(),newThingToUpdate.getEmployeeId(),
                newThingToUpdate.getLaboratoryToolId(),newThingToUpdate.getId());
        return updateQuery;

    }

    @Override
    protected String getTableName() {
        return "employee_laboratory_tools";
    }

    @Override
    protected String getTableFields() {
        return "employee_id,laboratory_tool_id";
    }

    @Override
    protected Long getThingId(EmployeeLaboratoryTools thing) {
        return thing.getId();
    }

    @Override
    protected EmployeeLaboratoryTools mapResultToObject(ResultSet resultSet, Connection conn) throws SQLException {
        EmployeeLaboratoryTools entity= new EmployeeLaboratoryTools();
        entity.setId(resultSet.getLong("id"));
        entity.setEmployeeId(resultSet.getLong("employee_id"));
        entity.setLaboratoryToolId(resultSet.getLong("laboratory_tool_id"));
        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, EmployeeLaboratoryTools thingToCreate) {
        try {
            ps.setLong(1,thingToCreate.getEmployeeId());
            ps.setLong(2,thingToCreate.getLaboratoryToolId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
