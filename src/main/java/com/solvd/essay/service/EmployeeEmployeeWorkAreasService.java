package com.solvd.essay.service;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.domain.EmployeeEmployeeWorkAreas;
import com.solvd.essay.domain.EmployeeWorkArea;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.EmployeeRepositoryImpl;
import com.solvd.essay.persistence.impl.EmployeeWorkAreaRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeEmployeeWorkAreasService {
    private final AbstractDao<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasImpl;

    public EmployeeEmployeeWorkAreasService(AbstractDao<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasAbstractDao){
        this.employeeEmployeeWorkAreasImpl = employeeEmployeeWorkAreasAbstractDao;
    }

    public void create(EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas){
        try {
            employeeEmployeeWorkAreasImpl.create(employeeEmployeeWorkAreas);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeEmployeeWorkAreas> findAll(Connection conn) throws SQLException {
        List<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasList=employeeEmployeeWorkAreasImpl.getAll();







        for (EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas: employeeEmployeeWorkAreasList) {

        }
        return employeeEmployeeWorkAreasList;
    }

    public EmployeeEmployeeWorkAreas findOne(Long id,Connection conn) throws SQLException {
        EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas= employeeEmployeeWorkAreasImpl.findById(id);


        return employeeEmployeeWorkAreas;
    }

    public void deleteOne(Long id) throws SQLException {
        employeeEmployeeWorkAreasImpl.deleteById(id);
    }

    public void deleteEntity(EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas){
        employeeEmployeeWorkAreasImpl.delete(employeeEmployeeWorkAreas);
    }

    public void updateEntity(EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas){
        try {
            employeeEmployeeWorkAreasImpl.update(employeeEmployeeWorkAreas);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
