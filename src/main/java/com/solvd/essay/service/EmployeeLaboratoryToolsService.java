package com.solvd.essay.service;

import com.solvd.essay.domain.EmployeeLaboratoryTools;
import com.solvd.essay.persistence.jdbcImpl.*;

import java.sql.SQLException;
import java.util.List;

public class EmployeeLaboratoryToolsService {
    private final AbstracDao<EmployeeLaboratoryTools> employeeLaboratoryToolsRepositoryImpl =new EmployeeLaboratoryToolsRepositoryImpl();

    public void create(EmployeeLaboratoryTools employeeLaboratoryTools){
            employeeLaboratoryToolsRepositoryImpl.create(employeeLaboratoryTools);
    }
    public List<EmployeeLaboratoryTools> findAll() throws SQLException {
        List<EmployeeLaboratoryTools> employeeLaboratoryToolsList= employeeLaboratoryToolsRepositoryImpl.getAll();

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
        EmployeeLaboratoryTools employeeLaboratoryTools = employeeLaboratoryToolsRepositoryImpl.findById(id);
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
        employeeLaboratoryToolsRepositoryImpl.deleteById(id);
    }



    public void updateEntity(EmployeeLaboratoryTools employeeLaboratoryTools,Long id){
        try {
            employeeLaboratoryToolsRepositoryImpl.updateById(employeeLaboratoryTools,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
