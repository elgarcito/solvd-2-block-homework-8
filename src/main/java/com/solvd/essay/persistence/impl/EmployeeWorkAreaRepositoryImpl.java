package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.EmployeeWorkArea;
import com.solvd.essay.persistence.EmployeeWorkAreaRepository;
import com.solvd.essay.persistence.LaboratoryToolRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeWorkAreaRepositoryImpl implements EmployeeWorkAreaRepository {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeWorkAreaRepositoryImpl.class);
    @Override
    public void create(EmployeeWorkArea thingToCreate) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeWorkAreaRepository employeeWorkAreaRepository= sqlSession.getMapper(EmployeeWorkAreaRepository.class);
            employeeWorkAreaRepository.create(thingToCreate);
        }catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<EmployeeWorkArea> getAll() throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            EmployeeWorkAreaRepository employeeWorkAreaRepository = sqlSession.getMapper(EmployeeWorkAreaRepository.class);
            return employeeWorkAreaRepository.getAll();
        }
    }

    @Override
    public EmployeeWorkArea findById(long id) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            EmployeeWorkAreaRepository employeeWorkAreaRepository = sqlSession.getMapper(EmployeeWorkAreaRepository.class);
            return employeeWorkAreaRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
            try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
                EmployeeWorkAreaRepository employeeWorkAreaRepository = sqlSession.getMapper(EmployeeWorkAreaRepository.class);
                employeeWorkAreaRepository.deleteById(thingId);
            }
    }

    @Override
    public void updateById(EmployeeWorkArea thingToUpdate, Long entityId) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            EmployeeWorkAreaRepository employeeWorkAreaRepository = sqlSession.getMapper(EmployeeWorkAreaRepository.class);
            employeeWorkAreaRepository.updateById(thingToUpdate,entityId);
        }
    }
}
