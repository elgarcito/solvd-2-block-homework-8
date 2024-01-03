package com.solvd.essay.service;

import com.solvd.essay.domain.EmployeeEmployeeWorkAreas;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.EmployeeEmployeeWorkAreasRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeEmployeeWorkAreasService {
    private final EmployeeEmployeeWorkAreasRepositoryImpl employeeEmployeeWorkAreasRepositoryImpl=new EmployeeEmployeeWorkAreasRepositoryImpl();

    public void create(EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas){
        try {
            employeeEmployeeWorkAreasRepositoryImpl.create(employeeEmployeeWorkAreas);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeEmployeeWorkAreas> findAll() throws SQLException {
        List<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasList= employeeEmployeeWorkAreasRepositoryImpl.getAll();
        return employeeEmployeeWorkAreasList;
    }

    public EmployeeEmployeeWorkAreas findOne(Long id) throws SQLException {
        EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas= employeeEmployeeWorkAreasRepositoryImpl.findById(id);
        return employeeEmployeeWorkAreas;
    }

    public void deleteOne(Long id) throws SQLException {
        employeeEmployeeWorkAreasRepositoryImpl.deleteById(id);
    }


    public void updateEntity(EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas, Long id){
        try {
            employeeEmployeeWorkAreasRepositoryImpl.updateById(employeeEmployeeWorkAreas,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
