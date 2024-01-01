package com.solvd.essay.service;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.EmployeeRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);
    EmployeeRepositoryImpl employeeRepositoryImpl=new EmployeeRepositoryImpl();
    public void create(Employee employee){
        try {
            employeeRepositoryImpl.create(employee);
            LOGGER.info("Object added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Employee> findAll() throws SQLException {
        List<Employee> list= employeeRepositoryImpl.getAll();
        LOGGER.info("List returned successfully");
        return list;
    }

    public Optional<Employee> findOne(Long id) throws SQLException {
        return Optional.ofNullable(employeeRepositoryImpl.findById(id));
    }

    public void deleteOne(Long id) throws SQLException {
        employeeRepositoryImpl.deleteById(id);
        LOGGER.info("Object deleted successfully");
    }


    public void updateEntity(Employee employee,Long id){
        try {
            employeeRepositoryImpl.updateById(employee,id);
            LOGGER.info("Object updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
