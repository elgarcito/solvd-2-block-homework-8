package com.solvd.essay.service;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.domain.EmployeeLaboratoryTools;
import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.EmployeeRepositoryImpl;
import com.solvd.essay.persistence.impl.LaboratoryToolRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeLaboratoryToolsService {
    private final AbstractDao<EmployeeLaboratoryTools> employeeLaboratoryToolsImpl;

    public EmployeeLaboratoryToolsService(AbstractDao<EmployeeLaboratoryTools> employeeLaboratoryToolsAbstractDao){
        this.employeeLaboratoryToolsImpl = employeeLaboratoryToolsAbstractDao;
    }

    public void create(EmployeeLaboratoryTools employeeLaboratoryTools){
        try {
            employeeLaboratoryToolsImpl.create(employeeLaboratoryTools);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeLaboratoryTools> findAll(Connection conn) throws SQLException {
        List<EmployeeLaboratoryTools> employeeLaboratoryToolsList= employeeLaboratoryToolsImpl.getAll();

        AbstractDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl(conn);
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstractDao<LaboratoryTool> laboratoryTooImpl = new LaboratoryToolRepositoryImpl(conn);
        LaboratoryToolService newLaboratoryToolService= new LaboratoryToolService(laboratoryTooImpl);


        for (EmployeeLaboratoryTools employeeLaboratoryTools: employeeLaboratoryToolsList) {
            employeeLaboratoryTools.setEmployee(newEmployeeService.findOne(employeeLaboratoryTools.getEmployeeId()));
            employeeLaboratoryTools.setLaboratoryTool(newLaboratoryToolService.findOne(employeeLaboratoryTools.getLaboratoryToolId()));
        }
        return employeeLaboratoryToolsList;
    }

    public EmployeeLaboratoryTools findOne(Long id,Connection conn) throws SQLException {
        EmployeeLaboratoryTools employeeLaboratoryTools = employeeLaboratoryToolsImpl.findById(id);
        AbstractDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl(conn);
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstractDao<LaboratoryTool> laboratoryTooImpl = new LaboratoryToolRepositoryImpl(conn);
        LaboratoryToolService newLaboratoryToolService= new LaboratoryToolService(laboratoryTooImpl);

        employeeLaboratoryTools.setEmployee(newEmployeeService.findOne(employeeLaboratoryTools.getEmployeeId()));
        employeeLaboratoryTools.setLaboratoryTool(newLaboratoryToolService.findOne(employeeLaboratoryTools.getLaboratoryToolId()));
        return employeeLaboratoryTools;
    }

    public void deleteOne(Long id) throws SQLException {
        employeeLaboratoryToolsImpl.deleteById(id);
    }

    public void deleteEntity(EmployeeLaboratoryTools employeeLaboratoryTools){
        employeeLaboratoryToolsImpl.delete(employeeLaboratoryTools);
    }

    public void updateEntity(EmployeeLaboratoryTools employeeLaboratoryTools){
        try {
            employeeLaboratoryToolsImpl.update(employeeLaboratoryTools);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
