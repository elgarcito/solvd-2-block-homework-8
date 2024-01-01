package com.solvd.essay.persistence.impl;

import com.solvd.essay.Main;
import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.persistence.BatchInfoRepository;
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

public class LaboratoryToolRepositoryImpl implements LaboratoryToolRepository {
    private static final Logger LOGGER = LogManager.getLogger(LaboratoryToolRepositoryImpl.class);
    @Override
    public void create(LaboratoryTool thingToCreate) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            LaboratoryToolRepository laboratoryToolRepository= sqlSession.getMapper(LaboratoryToolRepository.class);
            laboratoryToolRepository.create(thingToCreate);
        }catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<LaboratoryTool> getAll() throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            LaboratoryToolRepository laboratoryToolRepository = sqlSession.getMapper(LaboratoryToolRepository.class);
            return laboratoryToolRepository.getAll();
        }
    }

    @Override
    public LaboratoryTool findById(long id) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            LaboratoryToolRepository laboratoryToolRepository = sqlSession.getMapper(LaboratoryToolRepository.class);
            return laboratoryToolRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            LaboratoryToolRepository laboratoryToolRepository = sqlSession.getMapper(LaboratoryToolRepository.class);
            laboratoryToolRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(LaboratoryTool thingToUpdate, Long entityId) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            LaboratoryToolRepository laboratoryToolRepository = sqlSession.getMapper(LaboratoryToolRepository.class);
            laboratoryToolRepository.updateById(thingToUpdate,entityId);
        }
    }

}
