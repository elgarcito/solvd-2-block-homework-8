package com.solvd.essay.service;

import com.solvd.essay.domain.EmployeeLaboratoryTools;
import com.solvd.essay.patterns.factoryPattern.ImplementationFactory;
import com.solvd.essay.persistence.InterfaceGenericDao;
//import com.solvd.essay.persistence.jdbcImpl.*;

import java.sql.SQLException;
import java.util.List;

public class EmployeeLaboratoryToolsService {
    final InterfaceGenericDao<EmployeeLaboratoryTools> employeeLaboratoryToolsRepositoryImpl = ImplementationFactory.getEmployeeLaboratoryToolsRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());
    public void create(EmployeeLaboratoryTools employeeLaboratoryTools) throws SQLException {
            employeeLaboratoryToolsRepositoryImpl.create(employeeLaboratoryTools);
    }
    public List<EmployeeLaboratoryTools> findAll() throws SQLException {
        List<EmployeeLaboratoryTools> employeeLaboratoryToolsList= employeeLaboratoryToolsRepositoryImpl.getAll();
        return employeeLaboratoryToolsList;
    }

    public EmployeeLaboratoryTools findOne(Long id) throws SQLException {
        EmployeeLaboratoryTools employeeLaboratoryTools = employeeLaboratoryToolsRepositoryImpl.findById(id);
        if(employeeLaboratoryTools==null){
            return new EmployeeLaboratoryTools();
        }
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
