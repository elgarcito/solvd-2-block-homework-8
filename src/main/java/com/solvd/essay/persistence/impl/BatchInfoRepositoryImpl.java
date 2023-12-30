package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.domain.exceptions.ResourceNotFoundException;
import com.solvd.essay.persistence.BatchInfoRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BatchInfoRepositoryImpl  implements  BatchInfoRepository{
    @Override
    public void create(BatchInfo thingToCreate) {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            batchInfoRepository.create(thingToCreate);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<BatchInfo> getAll() throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            //batchInfoRepository.findById(3L).orElseThrow(()->new ResourceNotFoundException(String.format("Unable to find batch information with id '%d'",3L)));
            return batchInfoRepository.getAll();
        }
    }

    @Override
    public BatchInfo findById(long id) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            //batchInfoRepository.findById(3L).orElseThrow(()->new ResourceNotFoundException(String.format("Unable to find batch information with id '%d'",3L)));
            return batchInfoRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            batchInfoRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(BatchInfo thingToUpdate, Long entityId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            batchInfoRepository.updateById(thingToUpdate,entityId);
        }
    }

    /*
    @Override
    public void create(BatchInfo thingToCreate) {
        try(SqlSession sqlSession= PersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            batchInfoRepository.create(thingToCreate);
        }
    }

    @Override
    public List<Optional<BatchInfo>> getAll() {
        return null;
    }

    @Override
    public Optional<BatchInfo> findById(long id) {
        try(SqlSession sqlSession= PersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            //batchInfoRepository.findById(3L).orElseThrow(()->new ResourceNotFoundException(String.format("Unable to find batch information with id '%d'",3L)));
            return batchInfoRepository.findById(id);
        }

    }

    @Override
    public void deleteById(Long thingId) {
        try(SqlSession sqlSession= PersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            batchInfoRepository.deleteById(thingId);
        }
    }

    @Override
    public void delete(BatchInfo thingToDelete) {
        try(SqlSession sqlSession= PersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            batchInfoRepository.delete(thingToDelete);
        }
    }

    @Override
    public void updateById(BatchInfo batchInfo,Long thingToUpdateId) {
        try(SqlSession sqlSession= PersistenceConfig.getSessionFactory().openSession(true)){
            BatchInfoRepository batchInfoRepository= sqlSession.getMapper(BatchInfoRepository.class);
            batchInfoRepository.updateById(thingToUpdateId);
        }
    }
 */
}
