package com.solvd.essay.patterns.strategyPattern;

import com.solvd.essay.Main;
import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.service.BatchInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class FindBatchByIdWithService  implements StrategyBatch {
    private static final Logger LOGGER = LogManager.getLogger(FindBatchByIdWithService.class);
BatchInfoService batchInfoService=new BatchInfoService();

    @Override
    public String findBatchById(Long id) {
        try {
            BatchInfo batchInfo=this.batchInfoService.findOne(id);
            LOGGER.info("Batch number obtained using service");
            return batchInfo.getBatchNumber();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
