package com.solvd.essay.service;

import com.solvd.essay.domain.EmployeeLaboratoryTools;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.EmployeeLaboratoryToolsRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeLaboratoryToolsService {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeLaboratoryToolsService.class);
    private final EmployeeLaboratoryToolsRepositoryImpl employeeLaboratoryToolsRepositoryImpl=new EmployeeLaboratoryToolsRepositoryImpl();

    public void create(EmployeeLaboratoryTools employeeLaboratoryTools){
        try {
            employeeLaboratoryToolsRepositoryImpl.create(employeeLaboratoryTools);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeLaboratoryTools> findAll() throws SQLException {
        List<EmployeeLaboratoryTools> employeeLaboratoryToolsList= employeeLaboratoryToolsRepositoryImpl.getAll();
        return employeeLaboratoryToolsList;
    }

    public EmployeeLaboratoryTools findOne(Long id) throws SQLException {
        EmployeeLaboratoryTools employeeLaboratoryTools = employeeLaboratoryToolsRepositoryImpl.findById(id);
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
