package com.solvd.essay.persistence.myBatisImpl;

import com.solvd.essay.domain.TemperatureEssay;
import com.solvd.essay.persistence.MyPersistenceConfig;
import com.solvd.essay.persistence.TemperatureEssayRepository;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class TemperatureEssayRepositoryImpl implements TemperatureEssayRepository {
    private static final Logger LOGGER = LogManager.getLogger(TemperatureEssayRepositoryImpl.class);
    @Override
    public void create(TemperatureEssay thingToCreate)  {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            TemperatureEssayRepository temperatureEssayRepository= sqlSession.getMapper(TemperatureEssayRepository.class);
            temperatureEssayRepository.create(thingToCreate);
        }catch (SQLException | PersistenceException e){
            LOGGER.error(e.getMessage());
        }

    }

    @Override
    public List<TemperatureEssay> getAll() throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            TemperatureEssayRepository temperatureEssayRepository= sqlSession.getMapper(TemperatureEssayRepository.class);
            return temperatureEssayRepository.getAll();
        }
    }

    @Override
    public TemperatureEssay findById(long id) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            TemperatureEssayRepository temperatureEssayRepository= sqlSession.getMapper(TemperatureEssayRepository.class);
            return temperatureEssayRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            TemperatureEssayRepository temperatureEssayRepository= sqlSession.getMapper(TemperatureEssayRepository.class);
            temperatureEssayRepository.findById(thingId);
        }
    }

    @Override
    public void updateById(TemperatureEssay thingToUpdate, Long entityId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            TemperatureEssayRepository temperatureEssayRepository= sqlSession.getMapper(TemperatureEssayRepository.class);
            temperatureEssayRepository.updateById(thingToUpdate,entityId);
        }
    }
}
