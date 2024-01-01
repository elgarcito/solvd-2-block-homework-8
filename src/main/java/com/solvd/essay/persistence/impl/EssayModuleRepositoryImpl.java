package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.EmployeeWorkAreaRepository;
import com.solvd.essay.persistence.EssayModuleRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class EssayModuleRepositoryImpl implements EssayModuleRepository {
    private static final Logger LOGGER = LogManager.getLogger(EssayModuleRepositoryImpl.class);
    @Override
    public void create(EssayModule thingToCreate) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EssayModuleRepository essayModuleRepository= sqlSession.getMapper(EssayModuleRepository.class);
            essayModuleRepository.create(thingToCreate);
        }catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<EssayModule> getAll() throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EssayModuleRepository essayModuleRepository= sqlSession.getMapper(EssayModuleRepository.class);
            return essayModuleRepository.getAll();
        }
    }

    @Override
    public EssayModule findById(long id) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EssayModuleRepository essayModuleRepository= sqlSession.getMapper(EssayModuleRepository.class);
            return essayModuleRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EssayModuleRepository essayModuleRepository= sqlSession.getMapper(EssayModuleRepository.class);
            essayModuleRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(EssayModule thingToUpdate, Long entityId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EssayModuleRepository essayModuleRepository= sqlSession.getMapper(EssayModuleRepository.class);
            essayModuleRepository.updateById(thingToUpdate,entityId);
        }
    }
}
