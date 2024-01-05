package com.solvd.essay.service;

import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.persistence.impl.AbstracDao;
import com.solvd.essay.persistence.impl.BatchInfoRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class BatchInfoService {
    private final AbstracDao<BatchInfo> batchInfoImpl=new BatchInfoRepositoryImpl();

    public void create(BatchInfo batchInfo){
        try {
            batchInfoImpl.create(batchInfo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<BatchInfo> findAll() throws SQLException {
            return batchInfoImpl.getAll();
    }

    public BatchInfo findOne(Long id) throws SQLException {
        BatchInfo result= batchInfoImpl.findById(id);
        if (result==null){
            return new BatchInfo();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        batchInfoImpl.deleteById(id);
    }

    public void deleteEntity(BatchInfo batchInfo){
        batchInfoImpl.delete(batchInfo);
    }

    public void updateEntity(BatchInfo batchInfo,Long id){
        try {
            batchInfoImpl.update(batchInfo,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
