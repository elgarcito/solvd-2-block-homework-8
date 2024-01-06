package com.solvd.essay.persistence.myBatisImpl;

import com.solvd.essay.domain.EquipmentForTestModel;
import com.solvd.essay.persistence.EquipmentForTestModelRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class EquipmentForTestModelRepositoryImpl implements EquipmentForTestModelRepository {
    private static final Logger LOGGER = LogManager.getLogger(EquipmentForTestModelRepositoryImpl.class);
    @Override
    public void create(EquipmentForTestModel thingToCreate) {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EquipmentForTestModelRepository equipmentForTestModelRepository= sqlSession.getMapper(EquipmentForTestModelRepository.class);
            equipmentForTestModelRepository.create(thingToCreate);
        }catch (SQLException | PersistenceException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<EquipmentForTestModel> getAll() throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EquipmentForTestModelRepository equipmentForTestModelRepository= sqlSession.getMapper(EquipmentForTestModelRepository.class);
            return equipmentForTestModelRepository.getAll();
        }
    }

    @Override
    public EquipmentForTestModel findById(long id) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EquipmentForTestModelRepository equipmentForTestModelRepository= sqlSession.getMapper(EquipmentForTestModelRepository.class);
            return equipmentForTestModelRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
        EquipmentForTestModelRepository equipmentForTestModelRepository= sqlSession.getMapper(EquipmentForTestModelRepository.class);
        equipmentForTestModelRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(EquipmentForTestModel thingToUpdate, Long entityId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EquipmentForTestModelRepository equipmentForTestModelRepository= sqlSession.getMapper(EquipmentForTestModelRepository.class);
            equipmentForTestModelRepository.updateById(thingToUpdate,entityId);
        }
    }
}
