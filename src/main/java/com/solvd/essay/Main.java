package com.solvd.essay;


import com.solvd.essay.domain.*;
import com.solvd.essay.domain.exceptions.ResourceNotFoundException;
import com.solvd.essay.persistence.BatchInfoRepository;
import com.solvd.essay.service.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        BatchInfoService batchInfoService = new BatchInfoService();
        LaboratoryToolService laboratoryToolService = new LaboratoryToolService();
        EmployeeWorkAreaService employeeWorkAreaService = new EmployeeWorkAreaService();
        EmployeeService employeeService = new EmployeeService();
        EssayModuleService essayModuleService = new EssayModuleService();
        EquipmentForTestModelService equipmentForTestModelService = new EquipmentForTestModelService();
        LabTestReportService labTestReportService = new LabTestReportService();
        TemperatureEssayService temperatureEssayService=new TemperatureEssayService();
        EnergyEfficiencyEssayService energyEfficiencyEssayService=new EnergyEfficiencyEssayService();
        GasConsumptionEssayService gasConsumptionEssayService= new GasConsumptionEssayService();
        EmployeeEmployeeWorkAreasService employeeEmployeeWorkAreasService= new EmployeeEmployeeWorkAreasService();
        EmployeeLaboratoryToolsService employeeLaboratoryToolsService= new EmployeeLaboratoryToolsService();
            /*
            BatchInfo batchInfo1=new BatchInfo();
            batchInfo1.setBatchNumber("ksff14");
            batchInfoService.create(batchInfo1);
            batchInfoService.deleteOne(12L);
            batchInfo1.setBatchNumber("ksff14485");
            batchInfoService.updateEntity(batchInfo1,11L);
            Optional<BatchInfo> batchInfo2=batchInfoService.findOne(11L);
            System.out.println(batchInfo2.isPresent());
            BatchInfo batchInfo3= batchInfo2.get();
            System.out.println(batchInfo3.getBatchNumber());


            List<BatchInfo> list=batchInfoService.findAll();
            list.forEach(x-> System.out.println(x.getBatchNumber()));

             */

        //LaboratoryTools
        //Optional<LaboratoryTool> laboratoryTool= laboratoryToolService.findOne(5L);
        //System.out.println(laboratoryTool.get().getToolDescription());
        //LaboratoryTool laboratoryTool1= new LaboratoryTool();
        //laboratoryTool1.setToolName("tool8");
        //laboratoryTool1.setToolDescription("super tool1");
        //laboratoryToolService.create(laboratoryTool1);
        //laboratoryToolService.deleteOne(6L);
        //laboratoryToolService.updateEntity(laboratoryTool1,8L);
        //laboratoryToolService.findAll().forEach(x-> System.out.println(x.getToolDescription()));

        //EmployeeWorkAreas
        // Optional<EmployeeWorkArea> employeeWorkArea= employeeWorkAreaService.findOne(9L);
        //System.out.println(employeeWorkArea.get().getAreaName());

        //Employee
        //employeeService.findAll().forEach(x-> System.out.println(x.getFirstName()+x.getLastName()));

        //Essay module
        //essayModuleService.findAll().forEach(x-> System.out.println(x.getModuleDescription()));

        //Equipment for test model
        //equipmentForTestModelService.findAll().forEach(x-> System.out.println(x.getModelDescription()));

        //Lab test report
        /*
        Optional<LabTestReport> result = labTestReportService.findOne(1L);
        System.out.println(result.get().getEssayDescription());
        System.out.println(result.get().getEssayModule().getModuleDescription());
        List<LabTestReport> list = labTestReportService.findAll();
        list.forEach(x->x.getEmployee().getLastName());
         */
        //List<TemperatureEssay>list1= temperatureEssayService.findAll();
       // list1.forEach(x-> System.out.println(x.getLabTestReport().getEmployee().getLastName()));

      //  energyEfficiencyEssayService.findAll().forEach(x-> System.out.println(x.getLabTestReport().getEssayDescription()));

      //Gas consumption
        //gasConsumptionEssayService.findAll().forEach(x-> System.out.println(x.getLabTestReport().getEssayDescription()));
    //employeeLaboratoryToolsService.findAll().forEach(x-> System.out.println(x.getEmployee().getFirstName()));

    }
}