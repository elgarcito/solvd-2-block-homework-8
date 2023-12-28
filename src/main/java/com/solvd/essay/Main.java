package com.solvd.essay;


import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.domain.Employee;
import com.solvd.essay.domain.EmployeeWorkArea;
import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.impl.*;
import com.solvd.essay.service.BatchInfoService;
import com.solvd.essay.service.EmployeeService;
import com.solvd.essay.service.EmployeeWorkAreaService;
import com.solvd.essay.service.EssayModuleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        AbstracDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl(conn);
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstracDao<EmployeeWorkArea> newEmployeeWorkAreaImpl= new EmployeeWorkAreaRepositoryImpl(conn);
        EmployeeWorkAreaService newEmployeeWorkAreaService= new EmployeeWorkAreaService(newEmployeeWorkAreaImpl);


       // List<EssayModule> newList= newEssayModuleService.findAll();
      // newList.forEach(essayModule -> System.out.println(essayModule.getModuleDescription()));
        //EssayModule essayModule=newEssayModuleService.findOne(10L);

        // Batch info
        /*
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
        */

        //
        //Employee
        /*

        Employee employee1= new Employee();
        employee1.setId(7L);
        employee1.setFirstName("seth");
        employee1.setLastName("Roger");
        employee1.setPersonalId("");
        Date d1= Date.valueOf("1993-09-22");
        employee1.setBirthDate(d1);
        employee1.setSalary(1000.0);
        //newEmployeeService.create(employee1);
        EssayModule essayModule1= new EssayModule();
        essayModule1.setModuleDescription("modulo13");
        newEssayModuleService.create(essayModule1);
        System.out.println(String.format("update essay_module set module_description=\"%s\" where id= %s","edgar",12));
        String valuesToUpdate=String.format("\"%s \",\"%s\",\"%s\",\"%s\",%s",employee1.getFirstName(),employee1.getLastName(),
                employee1.getPersonalId(),employee1.getBirthDate(),employee1.getSalary());
        System.out.println(valuesToUpdate);
       // newEmployeeService.deleteEntity(employee1);
       // newEmployeeService.updateEntity(employee1);

         */

        //EmployeeWorkArea
        EmployeeWorkArea area2= new EmployeeWorkArea();
        area2.setAreaName("area new");
        area2.setAreaCode("area 2256");
        newEmployeeWorkAreaService.create(area2);
        EmployeeWorkArea area1= newEmployeeWorkAreaService.findOne(3L);
        System.out.println(area1.getAreaName());
        area2.setId(1L);
        area2.setAreaCode("area 29955");
        newEmployeeWorkAreaService.updateEntity(area2);
        //newEmployeeWorkAreaService.deleteOne(4L);
    }
}