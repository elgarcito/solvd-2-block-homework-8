package com.solvd.essay.service;

import com.solvd.essay.domain.EmployeeWorkArea;
import com.solvd.essay.persistence.EmployeeWorkAreaRepository;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.EmployeeWorkAreaRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EmployeeWorkAreaService {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeWorkAreaService.class);
    private final EmployeeWorkAreaRepository employeeWorkAreaRepository=new EmployeeWorkAreaRepositoryImpl();
    public void create(EmployeeWorkArea employeeWorkArea){
        try {
            employeeWorkAreaRepository.create(employeeWorkArea);
            LOGGER.info("Object added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeWorkArea> findAll() throws SQLException {
        List<EmployeeWorkArea> list= employeeWorkAreaRepository.getAll();
        LOGGER.info("List returned successfully");
            return list;
    }

    public Optional<EmployeeWorkArea> findOne(Long id) throws SQLException {
        return Optional.ofNullable(employeeWorkAreaRepository.findById(id));
    }

    public void deleteOne(Long id) throws SQLException {
        employeeWorkAreaRepository.deleteById(id);
        LOGGER.info("Object deleted successfully");
    }

    public void updateEntity(EmployeeWorkArea employeeWorkArea,Long id){
        try {
            employeeWorkAreaRepository.updateById(employeeWorkArea,id);
            LOGGER.info("Object updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
