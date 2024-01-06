package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.domain.Employee;

import java.sql.*;
import java.util.List;

public class EmployeeRepositoryImpl extends AbstractDao<Employee> {

    public EmployeeRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(Employee newThingToUpdate,Long id) {
        String updateQuery=String.format("update employee set first_name=\"%s\",last_name=\"%s\",personal_id=\"%s\",birth_date=\"%s\",salary=%s where id= %s",
                newThingToUpdate.getFirstName(),newThingToUpdate.getLastName(),newThingToUpdate.getPersonalId(),
                newThingToUpdate.getBirthDate(),newThingToUpdate.getSalary(),id);
        /*
        return "update employee set first_name=\""+newThingToUpdate.getFirstName()+"\""+
                "last_name=\""+newThingToUpdate.getLastName()+"\""+
                "personal_id=\""+newThingToUpdate.getPersonalId()+"\""+
                "birth_date=\""+newThingToUpdate.getBirthDate()+"\""+
                "salary=\""+newThingToUpdate.getSalary()+"\""+
                "where id="+newThingToUpdate.getId();

         */
        return updateQuery;
    }

    @Override
    protected String getTableName() {
        return "employee";
    }

    @Override
    protected String getTableFields() {
        return "first_name,last_name,personal_id,birth_date,salary";
    }

    /*
    @Override
    protected String getThingFields(Employee thing) {

        String valuesToUpdate= "\""+thing.getFirstName()+"\",\""+thing.getLastName()+"\",\""+thing.getPersonalId()
                +"\",\""+thing.getBirthDate()+"\","+thing.getSalary();

        String valuesToUpdate=String.format("\"%s \",\"%s\",\"%s\",\"%s\",%s",thing.getFirstName(),thing.getLastName(),
                thing.getPersonalId(),thing.getBirthDate(),thing.getSalary());
        return valuesToUpdate;
    }
     */



    @Override
    protected Long getThingId(Employee thing) {
        return thing.getId();
    }

    @Override
    protected Employee mapResultToObject(ResultSet resultSet,Connection conn) throws SQLException {
        Employee entity= new Employee();
        entity.setId(resultSet.getLong("id"));
        entity.setFirstName(resultSet.getString("first_name"));
        entity.setLastName(resultSet.getString("last_name"));
        entity.setPersonalId(resultSet.getString("personal_id"));
        entity.setBirthDate(resultSet.getDate(  "birth_date"));
        entity.setSalary(resultSet.getDouble(  "salary"));
        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?,?,?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, Employee thingToCreate) {
        try {
            ps.setString(1,thingToCreate.getFirstName());
            ps.setString(2,thingToCreate.getLastName());
            ps.setString(3,thingToCreate.getPersonalId());
            ps.setDate(4, thingToCreate.getBirthDate());
            ps.setDouble(5,thingToCreate.getSalary());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Employee returnVoidInstance() {
        return new Employee();
    }

    @Override
    protected void saveListInObject(Employee thing, List<Employee> list) {
        thing.setEmployeeList(list);
    }
}
