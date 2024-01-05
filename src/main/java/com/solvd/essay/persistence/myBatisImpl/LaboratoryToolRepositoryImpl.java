package com.solvd.essay.persistence.myBatisImpl;

import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.persistence.LaboratoryToolRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class LaboratoryToolRepositoryImpl implements LaboratoryToolRepository {
    private static final Logger LOGGER = LogManager.getLogger(LaboratoryToolRepositoryImpl.class);
    @Override
    public void create(LaboratoryTool thingToCreate)  {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            LaboratoryToolRepository laboratoryToolRepository= sqlSession.getMapper(LaboratoryToolRepository.class);
            laboratoryToolRepository.create(thingToCreate);
        }catch (SQLException | PersistenceException e){
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
