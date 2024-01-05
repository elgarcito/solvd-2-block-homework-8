package com.solvd.essay.persistence.myBatisImpl;

import com.solvd.essay.domain.EnergyEfficiencyEssay;
import com.solvd.essay.persistence.EnergyEfficiencyEssayRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class EnergyEfficiencyEssayRepositoryImpl implements EnergyEfficiencyEssayRepository {
    private static final Logger LOGGER = LogManager.getLogger(EnergyEfficiencyEssayRepositoryImpl.class);
    @Override
    public void create(EnergyEfficiencyEssay thingToCreate)  {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EnergyEfficiencyEssayRepository energyEfficiencyEssayRepository= sqlSession.getMapper(EnergyEfficiencyEssayRepository.class);
            energyEfficiencyEssayRepository.create(thingToCreate);
        }catch (SQLException | PersistenceException e){
            LOGGER.error(e.getMessage());
        }


    }

    @Override
    public List<EnergyEfficiencyEssay> getAll() throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EnergyEfficiencyEssayRepository energyEfficiencyEssayRepository= sqlSession.getMapper(EnergyEfficiencyEssayRepository.class);
            return energyEfficiencyEssayRepository.getAll();
        }
    }

    @Override
    public EnergyEfficiencyEssay findById(long id) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EnergyEfficiencyEssayRepository energyEfficiencyEssayRepository= sqlSession.getMapper(EnergyEfficiencyEssayRepository.class);
            return energyEfficiencyEssayRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EnergyEfficiencyEssayRepository energyEfficiencyEssayRepository= sqlSession.getMapper(EnergyEfficiencyEssayRepository.class);
            energyEfficiencyEssayRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(EnergyEfficiencyEssay thingToUpdate, Long entityId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EnergyEfficiencyEssayRepository energyEfficiencyEssayRepository= sqlSession.getMapper(EnergyEfficiencyEssayRepository.class);
            energyEfficiencyEssayRepository.updateById(thingToUpdate,entityId);
        }
    }
}
