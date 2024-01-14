package com.solvd.essay.service;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.patterns.factoryPattern.ImplementationFactory;
import com.solvd.essay.persistence.InterfaceGenericDao;
//import com.solvd.essay.persistence.jdbcImpl.AbstractDao;
//import com.solvd.essay.persistence.jdbcImpl.EmployeeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    final InterfaceGenericDao<Employee> employeeRepositoryImpl = ImplementationFactory.getEmployeeRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());


    public void create(Employee employee) throws SQLException {
            employeeRepositoryImpl.create(employee);
    }
    public List<Employee> findAll() throws SQLException {
            return employeeRepositoryImpl.getAll();
    }

    public Employee findOne(Long id) throws SQLException {
        Employee result= employeeRepositoryImpl.findById(id);
        if (result==null){
            return new Employee();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        employeeRepositoryImpl.deleteById(id);
    }

    public void updateEntity(Employee employee,Long id){
        try {
            employeeRepositoryImpl.updateById(employee, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
