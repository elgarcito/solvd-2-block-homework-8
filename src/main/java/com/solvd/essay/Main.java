package com.solvd.essay;


import com.solvd.essay.domain.*;
import com.solvd.essay.persistence.impl.*;
import com.solvd.essay.service.*;
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

        AbstracDao<EnergyEfficiencyEssay> energyEfficiencyEssayImpl= new EnergyEfficiencyEssayRepositoryImpl(conn);
        EnergyEfficiencyEssayService newEnergyEfficiencyEssayService= new EnergyEfficiencyEssayService(energyEfficiencyEssayImpl);

        AbstracDao<GasConsumptionEssay> newGasConsumptionEssayImpl=new GasConsumptionEssayRepositoryImpl(conn);
        GasConsumptionEssayService newGasConsumptionEssayService=new GasConsumptionEssayService(newGasConsumptionEssayImpl);

        AbstracDao<TemperatureEssay> temperatureEssayImpl = new TemperatureEssayRepositoryImpl(conn);
        TemperatureEssayService newTemperatureEssayService= new TemperatureEssayService(temperatureEssayImpl);

        AbstracDao<LaboratoryTool> laboratoryTooImpl = new LaboratoryToolRepositoryImpl(conn);
        LaboratoryToolService newLaboratoryToolService= new LaboratoryToolService(laboratoryTooImpl);

        AbstracDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl(conn);
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);

        AbstracDao<EquipmentForTestModel> equipmentForTestModelImpl= new EquipmentForTestModelRepositoryImpl(conn);
        EquipmentForTestModelService newEquipmentForTestModelService= new EquipmentForTestModelService(equipmentForTestModelImpl);

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

        /*
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

         */

        /*
        //Energy efficiency essay
        EnergyEfficiencyEssay eeEssay =new EnergyEfficiencyEssay();
        eeEssay.setValueOfEssay(25.0);
        eeEssay.setEssayResult(false);
        eeEssay.setLabTestReportId(19L);
        eeEssay.setCategory("A");
        //newEnergyEfficiencyEssayService.create(eeEssay);
        eeEssay.setId(9L);
        //newEnergyEfficiencyEssayService.deleteEntity(eeEssay);
        //newEnergyEfficiencyEssayService.updateEntity(eeEssay);
        EnergyEfficiencyEssay eeEssay2= newEnergyEfficiencyEssayService.findOne(5L,conn);
        System.out.println(eeEssay2.getLabTestReport().getEssayDescription());

        //List<EnergyEfficiencyEssay> eef= newEnergyEfficiencyEssayService.findAll(conn);
        //eef.forEach(x-> System.out.println(x.getLabTestReport().getEssayDescription()));
        /*

        /*
        //Gas consumption essay
        GasConsumptionEssay gcEssay =new GasConsumptionEssay();
        gcEssay.setMaxConsume(10.1);
        gcEssay.setStandardMean(9.8);
        gcEssay.setMeasurementError(0.1);
        gcEssay.setEssayResult(true);
        gcEssay.setLabTestReportId(20L);
        //newGasConsumptionEssayService.create(gcEssay);
        gcEssay.setId(6L);
        gcEssay.setMaxConsume(25.3);
        newGasConsumptionEssayService.updateEntity(gcEssay);
        GasConsumptionEssay gcEssay2= newGasConsumptionEssayService.findOne(5L,conn);
       // System.out.println(gcEssay2.getLabTestReport().getEssayDescription());
        List<GasConsumptionEssay> gcs= newGasConsumptionEssayService.findAll(conn);
        gcs.forEach(x-> System.out.println(x.getLabTestReport().getEssayDescription()));


         */

        /*
        //Temperature essay
        TemperatureEssay tEssay =new TemperatureEssay();
        tEssay.setFrontMeasurement(30.1);
        tEssay.setLeftSideMeasurement(25);
        tEssay.setEssayResult(false);
        tEssay.setLabTestReportId(21L);
        tEssay.setEssayResult(true);
        //newTemperatureEssayService.create(tEssay);
        tEssay.setId(7L);
        tEssay.setFrontMeasurement(45);
        newTemperatureEssayService.updateEntity(tEssay);
         */

        /*
        //Laboratory tool
        LaboratoryTool ltool=new LaboratoryTool();
        ltool.setToolName("tool1");
        ltool.setToolDescription("usefully tool");
        //newLaboratoryToolService.create(ltool);
        ltool.setId(5L);
        ltool.setToolName("tool5");
        newLaboratoryToolService.updateEntity(ltool);
         */

        /*
        //Lab test report
        LabTestReport ltr=new LabTestReport();
        ltr.setEssayCode("EA32");
        ltr.setDateOfEssay(Date.valueOf("2023-12-29"));
        ltr.setEssayDescription("essay from java");
        ltr.setEquipmentForTestModelId(1L);
        ltr.setBatchInfoId(2L);
        ltr.setEmployeeId(2L);
        ltr.setEssayModuleId(2L);
        //newLabTestReportService.create(ltr);
        ltr.setEssayDescription("essay from java updated");
        ltr.setId(24L);
        newLabTestReportService.updateEntity(ltr);
         */

        /*
        //Equipment for test model
        EquipmentForTestModel eqft= new EquipmentForTestModel();
        eqft.setModelName("model 4");
        eqft.setModelDescription("rare model");
        eqft.setReleaseDate(Date.valueOf("2023-12-29"));
        //newEquipmentForTestModelService.create(eqft);
        eqft.setId(5L);
        eqft.setModelDescription("super rare model");
        newEquipmentForTestModelService.updateEntity(eqft);

         */

    }
}