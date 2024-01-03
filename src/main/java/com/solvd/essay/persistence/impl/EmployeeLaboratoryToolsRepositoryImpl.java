package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.EmployeeLaboratoryTools;
import com.solvd.essay.persistence.EmployeeLaboratoryToolsRepository;
import com.solvd.essay.persistence.EmployeeRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeLaboratoryToolsRepositoryImpl implements EmployeeLaboratoryToolsRepository {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeLaboratoryToolsRepositoryImpl.class);
    @Override
    public void create(EmployeeLaboratoryTools thingToCreate) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeLaboratoryToolsRepository employeeLaboratoryToolsRepository = sqlSession.getMapper(EmployeeLaboratoryToolsRepository.class);
            employeeLaboratoryToolsRepository.create(thingToCreate);
        }catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<EmployeeLaboratoryTools> getAll() throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeLaboratoryToolsRepository employeeLaboratoryToolsRepository = sqlSession.getMapper(EmployeeLaboratoryToolsRepository.class);
            return employeeLaboratoryToolsRepository.getAll();
        }
    }

    @Override
    public EmployeeLaboratoryTools findById(long id) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeLaboratoryToolsRepository employeeLaboratoryToolsRepository = sqlSession.getMapper(EmployeeLaboratoryToolsRepository.class);
            return employeeLaboratoryToolsRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeLaboratoryToolsRepository employeeLaboratoryToolsRepository = sqlSession.getMapper(EmployeeLaboratoryToolsRepository.class);
            employeeLaboratoryToolsRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(EmployeeLaboratoryTools thingToUpdate, Long entityId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeLaboratoryToolsRepository employeeLaboratoryToolsRepository = sqlSession.getMapper(EmployeeLaboratoryToolsRepository.class);
            employeeLaboratoryToolsRepository.updateById(thingToUpdate,entityId);
        }
    }
}
