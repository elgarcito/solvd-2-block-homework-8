package com.solvd.essay.service;

import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.persistence.BatchInfoRepository;
import com.solvd.essay.persistence.impl.BatchInfoRepositoryImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BatchInfoService {
    private final BatchInfoRepository batchInfoRepository= new BatchInfoRepositoryImpl();
    public void create(BatchInfo batchInfo) throws SQLException {
        batchInfoRepository.create(batchInfo);
    }
    public List<BatchInfo> findAll() throws SQLException {
            return batchInfoRepository.getAll();
    }

    public Optional<BatchInfo> findOne(Long id) throws SQLException {
        return Optional.ofNullable(batchInfoRepository.findById(id));
    }

    public void deleteOne(Long id) throws SQLException {
        batchInfoRepository.deleteById(id);
    }

    public void updateEntity(BatchInfo batchInfo,Long entityId) throws SQLException {
        batchInfoRepository.updateById(batchInfo, entityId);
    }



}
