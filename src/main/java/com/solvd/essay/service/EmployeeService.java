package com.solvd.essay.service;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.persistence.impl.AbstractDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private final AbstractDao<Employee> employeeImpl;

    public EmployeeService(AbstractDao<Employee> employeeAbstractDao){
        this.employeeImpl = employeeAbstractDao;
    }

    public void create(Employee employee){
        try {
            employeeImpl.create(employee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Employee> findAll() throws SQLException {
            return employeeImpl.getAll();
    }

    public Employee findOne(Long id) throws SQLException {
        return employeeImpl.findById(id);
    }

    public void deleteOne(Long id) throws SQLException {
        employeeImpl.deleteById(id);
    }

    public void deleteEntity(Employee employee){
        employeeImpl.delete(employee);
    }

    public void updateEntity(Employee employee){
        try {
            employeeImpl.update(employee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
