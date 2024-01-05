package com.solvd.essay.service;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.domain.EmployeeEmployeeWorkAreas;
import com.solvd.essay.domain.EmployeeWorkArea;
import com.solvd.essay.persistence.impl.AbstracDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeWorkAreaService {
    private final AbstracDao<EmployeeWorkArea> employeeWorkAreaImpl;

    public EmployeeWorkAreaService(AbstracDao<EmployeeWorkArea> employeeWorkAreaAbstracDao){
        this.employeeWorkAreaImpl =employeeWorkAreaAbstracDao;
    }

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
