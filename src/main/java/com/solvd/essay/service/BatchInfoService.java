package com.solvd.essay.service;

import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.persistence.myBatisImpl.BatchInfoRepositoryImpl;
//import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
//import com.solvd.essay.persistence.jdbcImpl.BatchInfoRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class BatchInfoService {
    final BatchInfoRepositoryImpl batchInfoRepositoryImpl =new BatchInfoRepositoryImpl();
    //final AbstracDao<BatchInfo> batchInfoRepositoryImpl =new BatchInfoRepositoryImpl();



    public void create(BatchInfo batchInfo)  {
            batchInfoRepositoryImpl.create(batchInfo);
    }
    public List<BatchInfo> findAll() throws SQLException {
            return batchInfoRepositoryImpl.getAll();
    }

    public BatchInfo findOne(Long id) throws SQLException {
        BatchInfo result= batchInfoRepositoryImpl.findById(id);
        if (result==null){
            return new BatchInfo();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        batchInfoRepositoryImpl.deleteById(id);
    }



    public void updateEntity(BatchInfo batchInfo,Long id){
        try {
            batchInfoRepositoryImpl.updateById(batchInfo,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
