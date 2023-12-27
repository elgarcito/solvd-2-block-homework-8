package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.domain.EssayModule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepositoryImpl extends AbstracDao<Employee> {

    public EmployeeRepositoryImpl(Connection conn) {
        super(conn);
    }

    @Override
    protected String getUpdateQuery(Employee newThingToUpdate) {
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
    protected String getThingFields(Employee thing) {
        return null;
    }

    @Override
    protected Long getThingId(Employee thing) {
        return null;
    }

    @Override
    protected Employee mapResultToObject(ResultSet resultSet) throws SQLException {
        return null;
    }
}
