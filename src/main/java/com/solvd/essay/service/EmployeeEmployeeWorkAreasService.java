package com.solvd.essay.service;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.domain.EmployeeEmployeeWorkAreas;
import com.solvd.essay.domain.EmployeeWorkArea;
import com.solvd.essay.persistence.impl.AbstracDao;
import com.solvd.essay.persistence.impl.EmployeeRepositoryImpl;
import com.solvd.essay.persistence.impl.EmployeeWorkAreaRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeEmployeeWorkAreasService {
    private final AbstracDao<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasImpl;

    public EmployeeEmployeeWorkAreasService(AbstracDao<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasAbstracDao){
        this.employeeEmployeeWorkAreasImpl =employeeEmployeeWorkAreasAbstracDao;
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

        AbstracDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl(conn);
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstracDao<EmployeeWorkArea> newEmployeeWorkAreaImpl= new EmployeeWorkAreaRepositoryImpl(conn);
        EmployeeWorkAreaService newEmployeeWorkAreaService= new EmployeeWorkAreaService(newEmployeeWorkAreaImpl);

        for (EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas: employeeEmployeeWorkAreasList) {
            employeeEmployeeWorkAreas.setEmployee(newEmployeeService.findOne(employeeEmployeeWorkAreas.getEmployeeId()));
            employeeEmployeeWorkAreas.setEmployeeWorkArea(newEmployeeWorkAreaService.findOne(employeeEmployeeWorkAreas.getEmployeeworkAreaId()));
        }
        return employeeEmployeeWorkAreasList;
    }

    public EmployeeEmployeeWorkAreas findOne(Long id,Connection conn) throws SQLException {
        EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas= employeeEmployeeWorkAreasImpl.findById(id);
        AbstracDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl(conn);
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstracDao<EmployeeWorkArea> newEmployeeWorkAreaImpl= new EmployeeWorkAreaRepositoryImpl(conn);
        EmployeeWorkAreaService newEmployeeWorkAreaService= new EmployeeWorkAreaService(newEmployeeWorkAreaImpl);

        employeeEmployeeWorkAreas.setEmployee(newEmployeeService.findOne(employeeEmployeeWorkAreas.getEmployeeId()));
        employeeEmployeeWorkAreas.setEmployeeWorkArea(newEmployeeWorkAreaService.findOne(employeeEmployeeWorkAreas.getEmployeeworkAreaId()));
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
