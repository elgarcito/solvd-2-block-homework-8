package com.solvd.essay;


import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.impl.AbstracDao;
import com.solvd.essay.persistence.impl.EssayModuleRepositoryImpl;
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
       // List<EssayModule> newList= newEssayModuleService.findAll();
      // newList.forEach(essayModule -> System.out.println(essayModule.getModuleDescription()));
        //EssayModule essayModule=newEssayModuleService.findOne(10L);
        newEssayModuleService.deleteOne(5L);
    }
}