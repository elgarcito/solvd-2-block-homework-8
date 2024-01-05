package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.domain.EmployeeEmployeeWorkAreas;
import com.solvd.essay.service.EmployeeService;
import com.solvd.essay.service.EmployeeWorkAreaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeEmployeeWorkAreasRepositoryImpl extends AbstracDao<EmployeeEmployeeWorkAreas>{
    private static final Logger LOGGER = LogManager.getLogger(EmployeeEmployeeWorkAreasRepositoryImpl.class);
    public EmployeeEmployeeWorkAreasRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(EmployeeEmployeeWorkAreas newThingToUpdate,Long id) {
        try {
        String updateQuery=String.format("update %s set employee_id= %s,employee_work_area_id= %s where id=%s"
                ,getTableName(),newThingToUpdate.getEmployee().getId(),
                newThingToUpdate.getEmployeeWorkArea().getId(),id);
        return updateQuery;
    }catch (NullPointerException e){
        LOGGER.info("The update can't be null in any field");
        return "invalid update";
        }
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
        //entity.setEmployeeId(resultSet.getLong("employee_id"));
        //entity.setEmployeeworkAreaId(resultSet.getLong("employee_work_area_id"));

        EmployeeService newEmployeeService= new EmployeeService();

        EmployeeWorkAreaService newEmployeeWorkAreaService= new EmployeeWorkAreaService();

        entity.setEmployee(newEmployeeService.findOne(resultSet.getLong("employee_id")));
        entity.setEmployeeWorkArea(newEmployeeWorkAreaService.findOne(resultSet.getLong("employee_work_area_id")));


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
            ps.setLong(1,thingToCreate.getEmployee().getId());
            ps.setLong(2,thingToCreate.getEmployeeWorkArea().getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected EmployeeEmployeeWorkAreas returnVoidInstance() {
        return new EmployeeEmployeeWorkAreas();
    }

    @Override
    protected void saveListInObject(EmployeeEmployeeWorkAreas thing, List<EmployeeEmployeeWorkAreas> list) {
        thing.setEmployeeEmployeeWorkAreasList(list);
    }
}

