package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.domain.EmployeeWorkArea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeWorkAreaRepositoryImpl extends AbstracDao<EmployeeWorkArea> {
    public EmployeeWorkAreaRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(EmployeeWorkArea newThingToUpdate,Long id) {
        String updateQuery=String.format("update %s set area_name=\"%s\", area_code=\"%s\" where id=%s",
                getTableName(),newThingToUpdate.getAreaName(),newThingToUpdate.getAreaCode(),id);
        return updateQuery;
    }

    @Override
    protected String getTableName() {
        return "employee_work_area";
    }

    @Override
    protected String getTableFields() {
        return "area_name,area_code";
    }

    /*
    @Override
    protected String getThingFields(EmployeeWorkArea thing) {
        String returnValue=String.format("\"s%\",\"s%\"",thing.getAreaName(),
                thing.getAreaCode());
        return returnValue;
    }

     */

    @Override
    protected Long getThingId(EmployeeWorkArea thing) {
        return thing.getId();
    }
    @Override
    protected EmployeeWorkArea mapResultToObject(ResultSet resultSet,Connection conn) throws SQLException {
        EmployeeWorkArea entity= new EmployeeWorkArea();
        entity.setId(resultSet.getLong("id"));
        entity.setAreaName(resultSet.getString("area_name"));
        entity.setAreaCode(resultSet.getString("area_code"));
        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, EmployeeWorkArea thingToCreate) {
        try {
            ps.setString(1,thingToCreate.getAreaName());
            ps.setString(2,thingToCreate.getAreaCode());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected EmployeeWorkArea returnVoidInstance() {
        return new EmployeeWorkArea();
    }

    @Override
    protected void saveListInObject(EmployeeWorkArea thing, List<EmployeeWorkArea> list) {
        thing.setEmployeeWorkAreaList(list);
    }
}
