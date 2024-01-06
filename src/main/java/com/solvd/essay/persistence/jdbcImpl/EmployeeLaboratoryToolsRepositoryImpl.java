package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.domain.EmployeeLaboratoryTools;
import com.solvd.essay.service.EmployeeService;
import com.solvd.essay.service.LaboratoryToolService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeLaboratoryToolsRepositoryImpl extends AbstractDao<EmployeeLaboratoryTools> {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeLaboratoryToolsRepositoryImpl.class);
    public EmployeeLaboratoryToolsRepositoryImpl() {}

    @Override
    protected String getUpdateQuery(EmployeeLaboratoryTools newThingToUpdate,Long id) {
        try {
        String updateQuery=String.format("update %s set employee_id= %s,laboratory_tool_id= %s where id=%s"
                ,getTableName(),newThingToUpdate.getEmployee().getId(),
                newThingToUpdate.getLaboratoryTool().getId(),id);
        return updateQuery;
    }catch (NullPointerException e){
        LOGGER.info("The update can't be null in any field");
        return "invalid update";
    }

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


        EmployeeService newEmployeeService= new EmployeeService();

        LaboratoryToolService newLaboratoryToolService= new LaboratoryToolService();

        entity.setEmployee(newEmployeeService.findOne(resultSet.getLong("employee_id")));
        entity.setLaboratoryTool(newLaboratoryToolService.findOne(resultSet.getLong("laboratory_tool_id")));


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
            ps.setLong(1,thingToCreate.getEmployee().getId());
            ps.setLong(2,thingToCreate.getLaboratoryTool().getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected EmployeeLaboratoryTools returnVoidInstance() {
        return new EmployeeLaboratoryTools();
    }

    @Override
    protected void saveListInObject(EmployeeLaboratoryTools thing, List<EmployeeLaboratoryTools> list) {
        thing.setEmployeeLaboratoryToolsList(list);
    }
}
