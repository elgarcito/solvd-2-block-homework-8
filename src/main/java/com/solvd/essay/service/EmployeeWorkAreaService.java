package com.solvd.essay.service;

import com.solvd.essay.domain.EmployeeWorkArea;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.EmployeeWorkAreaRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeWorkAreaService {
    private final AbstracDao<EmployeeWorkArea> employeeWorkAreaImpl= new EmployeeWorkAreaRepositoryImpl();

    public void create(EmployeeWorkArea employeeWorkArea){
        try {
            employeeWorkAreaImpl.create(employeeWorkArea);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeWorkArea> findAll() throws SQLException {
            return employeeWorkAreaImpl.getAll();
    }

    public EmployeeWorkArea findOne(Long id) throws SQLException {
        EmployeeWorkArea result= employeeWorkAreaImpl.findById(id);
        if (result==null){
            return new EmployeeWorkArea();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        employeeWorkAreaImpl.deleteById(id);
    }

    public void deleteEntity(EmployeeWorkArea employeeWorkArea){
        employeeWorkAreaImpl.delete(employeeWorkArea);
    }

    public void updateEntity(EmployeeWorkArea employeeWorkArea,Long id){
        try {
            employeeWorkAreaImpl.update(employeeWorkArea, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
