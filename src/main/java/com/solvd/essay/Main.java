package com.solvd.essay;


import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.impl.AbstracDao;
import com.solvd.essay.persistence.impl.BatchInfoRepositoryImpl;
import com.solvd.essay.persistence.impl.EssayModuleRepositoryImpl;
import com.solvd.essay.service.BatchInfoService;
import com.solvd.essay.service.EssayModuleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");

    }
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/solvd_essay","root","Edgar1269!");
        conn.setAutoCommit(false);
        AbstracDao<EssayModule> newEssayModuleImplementation = new EssayModuleRepositoryImpl(conn);
        EssayModuleService newEssayModuleService= new EssayModuleService(newEssayModuleImplementation);
        AbstracDao<BatchInfo> newBatchInfoImplementation= new BatchInfoRepositoryImpl(conn);
        BatchInfoService newBatchInfoService= new BatchInfoService(newBatchInfoImplementation);

       // List<EssayModule> newList= newEssayModuleService.findAll();
      // newList.forEach(essayModule -> System.out.println(essayModule.getModuleDescription()));
        //EssayModule essayModule=newEssayModuleService.findOne(10L);


        newEssayModuleService.deleteOne(5L);
        List<BatchInfo> newBatchInfoList= newBatchInfoService.findAll();
        newBatchInfoList.forEach(batchInfo ->LOGGER.info(batchInfo.getId()+" "+batchInfo.getBatchNumber()));
        BatchInfo newBatchInfo= new BatchInfo();
        newBatchInfo.setBatchNumber("l584");
        newBatchInfo.setId(9L);
        newBatchInfoService.create(newBatchInfo);
        newBatchInfoService.deleteOne(4L);
        BatchInfo found1=newBatchInfoService.findOne(1L);
        LOGGER.info(found1.getId()+found1.getBatchNumber());
        newBatchInfoService.deleteEntity(newBatchInfo);

    }
}