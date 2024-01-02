package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.GasConsumptionEssay;
import com.solvd.essay.persistence.EmployeeWorkAreaRepository;
import com.solvd.essay.persistence.GasConsumptionRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import com.solvd.essay.service.EmployeeWorkAreaService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GasConsumptionEssayRepositoryImpl implements GasConsumptionRepository {
    private static final Logger LOGGER = LogManager.getLogger(GasConsumptionEssayRepositoryImpl.class);

    @Override
    public void create(GasConsumptionEssay thingToCreate) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            GasConsumptionRepository gasConsumptionRepository = sqlSession.getMapper(GasConsumptionRepository.class);
            gasConsumptionRepository.create(thingToCreate);
        }
    }

    @Override
    public List<GasConsumptionEssay> getAll() throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            GasConsumptionRepository gasConsumptionRepository = sqlSession.getMapper(GasConsumptionRepository.class);
            return gasConsumptionRepository.getAll();
        }
    }

    @Override
    public GasConsumptionEssay findById(long id) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            GasConsumptionRepository gasConsumptionRepository = sqlSession.getMapper(GasConsumptionRepository.class);
            return gasConsumptionRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            GasConsumptionRepository gasConsumptionRepository = sqlSession.getMapper(GasConsumptionRepository.class);
            gasConsumptionRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(GasConsumptionEssay thingToUpdate, Long entityId) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            GasConsumptionRepository gasConsumptionRepository = sqlSession.getMapper(GasConsumptionRepository.class);
            gasConsumptionRepository.updateById(thingToUpdate,entityId);
        }
    }
}