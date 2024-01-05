package com.solvd.essay.service;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.domain.EmployeeLaboratoryTools;
import com.solvd.essay.domain.EmployeeWorkArea;
import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.persistence.impl.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeLaboratoryToolsService {
    private final AbstracDao<EmployeeLaboratoryTools> employeeLaboratoryToolsImpl=new EmployeeLaboratoryToolsRepositoryImpl();

    public void create(EmployeeLaboratoryTools employeeLaboratoryTools){
        try {
            employeeLaboratoryToolsImpl.create(employeeLaboratoryTools);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeLaboratoryTools> findAll() throws SQLException {
        List<EmployeeLaboratoryTools> employeeLaboratoryToolsList= employeeLaboratoryToolsImpl.getAll();

        /*
        AbstracDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl();
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstracDao<LaboratoryTool> laboratoryTooImpl = new LaboratoryToolRepositoryImpl();
        LaboratoryToolService newLaboratoryToolService= new LaboratoryToolService(laboratoryTooImpl);


        for (EmployeeLaboratoryTools employeeLaboratoryTools: employeeLaboratoryToolsList) {
            employeeLaboratoryTools.setEmployee(newEmployeeService.findOne(employeeLaboratoryTools.getEmployeeId()));
            employeeLaboratoryTools.setLaboratoryTool(newLaboratoryToolService.findOne(employeeLaboratoryTools.getLaboratoryToolId()));
        }

         */
        return employeeLaboratoryToolsList;
    }

    public EmployeeLaboratoryTools findOne(Long id) throws SQLException {
        EmployeeLaboratoryTools employeeLaboratoryTools = employeeLaboratoryToolsImpl.findById(id);
        if(employeeLaboratoryTools==null){
            return new EmployeeLaboratoryTools();
        }
        /*
        AbstracDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl();
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstracDao<LaboratoryTool> laboratoryTooImpl = new LaboratoryToolRepositoryImpl();
        LaboratoryToolService newLaboratoryToolService= new LaboratoryToolService(laboratoryTooImpl);

        employeeLaboratoryTools.setEmployee(newEmployeeService.findOne(employeeLaboratoryTools.getEmployeeId()));
        employeeLaboratoryTools.setLaboratoryTool(newLaboratoryToolService.findOne(employeeLaboratoryTools.getLaboratoryToolId()));

         */
        return employeeLaboratoryTools;
    }

    public void deleteOne(Long id) throws SQLException {
        employeeLaboratoryToolsImpl.deleteById(id);
    }

    public void deleteEntity(EmployeeLaboratoryTools employeeLaboratoryTools){
        employeeLaboratoryToolsImpl.delete(employeeLaboratoryTools);
    }

    public void updateEntity(EmployeeLaboratoryTools employeeLaboratoryTools,Long id){
        try {
            employeeLaboratoryToolsImpl.update(employeeLaboratoryTools,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
