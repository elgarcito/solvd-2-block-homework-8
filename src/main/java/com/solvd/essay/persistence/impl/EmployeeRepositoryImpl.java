package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.Employee;
import com.solvd.essay.persistence.EmployeeRepository;
import com.solvd.essay.persistence.EmployeeWorkAreaRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeRepositoryImpl.class);
    @Override
    public void create(Employee thingToCreate) {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeRepository employeeRepository= sqlSession.getMapper(EmployeeRepository.class);
            employeeRepository.create(thingToCreate);
        }catch (SQLException|PersistenceException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeRepository employeeRepository= sqlSession.getMapper(EmployeeRepository.class);
            return employeeRepository.getAll();
        }
    }

    @Override
    public Employee findById(long id) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeRepository employeeRepository= sqlSession.getMapper(EmployeeRepository.class);
            return employeeRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeRepository employeeRepository= sqlSession.getMapper(EmployeeRepository.class);
            employeeRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(Employee thingToUpdate, Long entityId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeRepository employeeRepository= sqlSession.getMapper(EmployeeRepository.class);
            employeeRepository.updateById(thingToUpdate,entityId);
        }
    }
}
