package com.solvd.essay;


import com.solvd.essay.domain.*;
import com.solvd.essay.persistence.impl.*;
import com.solvd.essay.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

        //Database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/solvd_essay","root","Edgar1269!");
        conn.setAutoCommit(false);

        //EssayModule class implementation and service creation
        AbstracDao<EssayModule> newEssayModuleImplementation = new EssayModuleRepositoryImpl();
        EssayModuleService newEssayModuleService= new EssayModuleService(newEssayModuleImplementation);

        EssayModule essayModule=newEssayModuleService.findOne(1L);
        LOGGER.info(essayModule.toString());
        List<EssayModule> essayModuleList= newEssayModuleService.findAll();
        essayModuleList.forEach(x->LOGGER.info(x.toString()));
        EssayModule essayModule1=new EssayModule();
        essayModule1.setModuleDescription("module 125");
        newEssayModuleService.create(essayModule1);
        essayModule1.setId(5L);
        newEssayModuleService.updateEntity(essayModule1,5L);


        System.out.println();
        System.out.println();
        System.out.println();


        //BatchInfo class implementation and service creation
        AbstracDao<BatchInfo> newBatchInfoImplementation= new BatchInfoRepositoryImpl();
        BatchInfoService newBatchInfoService= new BatchInfoService(newBatchInfoImplementation);

        //Usage of the service
        BatchInfo found1=newBatchInfoService.findOne(500L);
        LOGGER.info(found1.toString());
        List<BatchInfo> newBatchInfoList= newBatchInfoService.findAll();
        newBatchInfoList.forEach(batchInfo ->LOGGER.info(batchInfo.toString()));
        BatchInfo newBatchInfo= new BatchInfo();
        newBatchInfo.setBatchNumber("l584adf555");
        newBatchInfo.setId(7L);
        newBatchInfoService.create(newBatchInfo);
        newBatchInfoService.deleteOne(5L);
        newBatchInfoService.updateEntity(newBatchInfo,5L);


        System.out.println();
        System.out.println();
        System.out.println();

        //Employee class implementation and service creation
        AbstracDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl();
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        //Usage of the service
        Employee employee1=newEmployeeService.findOne(2L);
        LOGGER.info(employee1.toString());
        List<Employee>  employeeList = newEmployeeService.findAll();
        employeeList.forEach(x->LOGGER.info(x.toString()));
        Employee employee2= new Employee();
        employee2.setId(7L);
        employee2.setFirstName("seth");
        employee2.setLastName("Roger");
        employee2.setPersonalId("");
        Date d1= Date.valueOf("1993-09-22");
        employee2.setBirthDate(d1);
        employee2.setSalary(1000.0);
        newEmployeeService.create(employee2);
        newEmployeeService.deleteOne(20L);
        employee2.setPersonalId("1285");
        employee2.setId(23L);
        newEmployeeService.updateEntity(employee2,23L);


        System.out.println();
        System.out.println();
        System.out.println();


        //EmployeeWorkArea class implementation and service creation
        AbstracDao<EmployeeWorkArea> newEmployeeWorkAreaImpl= new EmployeeWorkAreaRepositoryImpl();
        EmployeeWorkAreaService newEmployeeWorkAreaService= new EmployeeWorkAreaService(newEmployeeWorkAreaImpl);

        //Usage of the service
        EmployeeWorkArea area1= newEmployeeWorkAreaService.findOne(3L);
        LOGGER.info(area1.toString());
        List<EmployeeWorkArea>employeeWorkAreaList=newEmployeeWorkAreaService.findAll();
        employeeWorkAreaList.forEach(x->LOGGER.info(x.toString()));
        EmployeeWorkArea area2= new EmployeeWorkArea();
        area2.setAreaName("area new1");
        area2.setAreaCode("area 2256");
        newEmployeeWorkAreaService.create(area2);
        area2.setId(1L);
        area2.setAreaCode("area 299565");
        newEmployeeWorkAreaService.updateEntity(area2,1L);
        newEmployeeWorkAreaService.deleteOne(4L);

        System.out.println();
        System.out.println();
        System.out.println();

        //EnergyEfficiencyEssay class implementation and service creation
        AbstracDao<EnergyEfficiencyEssay> energyEfficiencyEssayImpl= new EnergyEfficiencyEssayRepositoryImpl();
        EnergyEfficiencyEssayService newEnergyEfficiencyEssayService= new EnergyEfficiencyEssayService(energyEfficiencyEssayImpl);

        //Usage of the service
        EnergyEfficiencyEssay eeEssay2= newEnergyEfficiencyEssayService.findOne(5L);
        LOGGER.info(eeEssay2.toString());
        List<EnergyEfficiencyEssay> eefList= newEnergyEfficiencyEssayService.findAll();
        eefList.forEach(x->LOGGER.info(x.toString()));
        EnergyEfficiencyEssay eeEssay =new EnergyEfficiencyEssay();
        eeEssay.setValueOfEssay(25.0);
        eeEssay.setEssayResult(false);
        eeEssay.setCategory("A");
        newEnergyEfficiencyEssayService.create(eeEssay);
        eeEssay.setId(9L);
        newEnergyEfficiencyEssayService.updateEntity(eeEssay,9L);

        System.out.println();
        System.out.println();
        System.out.println();

        //GasConsumptionEssay class implementation and service creation

        AbstracDao<GasConsumptionEssay> newGasConsumptionEssayImpl=new GasConsumptionEssayRepositoryImpl();
        GasConsumptionEssayService newGasConsumptionEssayService=new GasConsumptionEssayService(newGasConsumptionEssayImpl);

        //Usage of the service
        GasConsumptionEssay gcEssay2= newGasConsumptionEssayService.findOne(5L);
        LOGGER.info(gcEssay2.toString());
        List<GasConsumptionEssay> gcs= newGasConsumptionEssayService.findAll();
        gcs.forEach(x-> LOGGER.info(x.toString()));
        GasConsumptionEssay gcEssay =new GasConsumptionEssay();
        gcEssay.setMaxConsume(10.1);
        gcEssay.setStandardMean(9.8);
        gcEssay.setMeasurementError(0.1);
        gcEssay.setEssayResult(true);

        newGasConsumptionEssayService.create(gcEssay);
        gcEssay.setId(6L);
        gcEssay.setMaxConsume(25.3);
        newGasConsumptionEssayService.updateEntity(gcEssay,6L);
        newGasConsumptionEssayService.deleteOne(6L);

        System.out.println();
        System.out.println();
        System.out.println();

        //TemperatureEssay class implementation and service creation
        AbstracDao<TemperatureEssay> temperatureEssayImpl = new TemperatureEssayRepositoryImpl();
        TemperatureEssayService newTemperatureEssayService= new TemperatureEssayService(temperatureEssayImpl);

        //Usage of the service
        TemperatureEssay temperatureEssay1=newTemperatureEssayService.findOne(4L);
        LOGGER.info(temperatureEssay1.toString());
        List<TemperatureEssay>temperatureEssayList=newTemperatureEssayService.findAll();
        temperatureEssayList.forEach(x-> LOGGER.info(x.toString()));
        TemperatureEssay tEssay =new TemperatureEssay();
        tEssay.setFrontMeasurement(30.1);
        tEssay.setLeftSideMeasurement(25);
        tEssay.setEssayResult(false);

        tEssay.setEssayResult(true);
        newTemperatureEssayService.create(tEssay);
        tEssay.setId(7L);
        tEssay.setFrontMeasurement(45);
        newTemperatureEssayService.updateEntity(tEssay,7L);

        System.out.println();
        System.out.println();
        System.out.println();

        //LaboratoryTool class implementation and service creation
        AbstracDao<LaboratoryTool> laboratoryTooImpl = new LaboratoryToolRepositoryImpl();
        LaboratoryToolService newLaboratoryToolService= new LaboratoryToolService(laboratoryTooImpl);

        //Usage of the service
        LaboratoryTool laboratoryTool=newLaboratoryToolService.findOne(1L);
        LOGGER.info(laboratoryTool.toString());
        List<LaboratoryTool> laboratoryToolList=newLaboratoryToolService.findAll();
        laboratoryToolList.forEach(x-> LOGGER.info(x.toString()));
        LaboratoryTool ltool=new LaboratoryTool();
        ltool.setToolName("tool1");
        ltool.setToolDescription("usefully tool");
        newLaboratoryToolService.create(ltool);
        ltool.setId(5L);
        ltool.setToolName("tool5");
        newLaboratoryToolService.deleteOne(6L);
        newLaboratoryToolService.updateEntity(ltool,5L);

        System.out.println();
        System.out.println();
        System.out.println();

        //LabTestReport class implementation and service creation
        AbstracDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);

        //Usage of the service
        LabTestReport labTestReport1=newLabTestReportService.findOne(100L);
        LOGGER.info(labTestReport1);
        List<LabTestReport> labTestReportList=newLabTestReportService.findAll();
        labTestReportList.forEach(x-> LOGGER.info(x.toString()));
        LabTestReport ltr=new LabTestReport();
        ltr.setEssayCode("EA32");
        ltr.setDateOfEssay(Date.valueOf("2023-12-29"));
        ltr.setEssayDescription("essay from java");
        newLabTestReportService.create(ltr);
        ltr.setEssayDescription("essay from java updated");
        ltr.setId(24L);
        newLabTestReportService.updateEntity(ltr,24L);
        newLabTestReportService.deleteOne(24L);

        System.out.println();
        System.out.println();
        System.out.println();

        //EquipmentForTestModel class implementation and service creation
        AbstracDao<EquipmentForTestModel> equipmentForTestModelImpl= new EquipmentForTestModelRepositoryImpl();
        EquipmentForTestModelService newEquipmentForTestModelService= new EquipmentForTestModelService(equipmentForTestModelImpl);

        //Usage of the service
        EquipmentForTestModel equipmentForTestModel1=newEquipmentForTestModelService.findOne(3L);
        LOGGER.info(equipmentForTestModel1.toString());
        EquipmentForTestModel eqft= new EquipmentForTestModel();
        eqft.setModelName("model 11");
        eqft.setModelDescription("rare model5");
        eqft.setReleaseDate(Date.valueOf("2023-12-29"));
        newEquipmentForTestModelService.create(eqft);
        eqft.setId(9L);
        eqft.setModelDescription("super duper rare model");
        List<EquipmentForTestModel>list1=new ArrayList<>();
        list1=newEquipmentForTestModelService.findAll();
        list1.forEach(x-> LOGGER.info(x.toString()));
        newEquipmentForTestModelService.deleteOne(6L);
        eqft.setModelDescription("rare rare model");
        newEquipmentForTestModelService.updateEntity(eqft,6L);

        System.out.println();
        System.out.println();
        System.out.println();
        //Intermediate tables
        //EmployeeEmployeeWorkAreas class implementation and service creation
        AbstracDao<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasImpl =new EmployeeEmployeeWorkAreasRepositoryImpl();
        EmployeeEmployeeWorkAreasService newEmployeeEmployeeWorkAreasService =new EmployeeEmployeeWorkAreasService(employeeEmployeeWorkAreasImpl);
        //Usage of the service
        EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas= newEmployeeEmployeeWorkAreasService.findOne(1L);
        LOGGER.info(employeeEmployeeWorkAreas);
        List<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasList=newEmployeeEmployeeWorkAreasService.findAll();
        employeeEmployeeWorkAreasList.forEach(x->LOGGER.info(x.toString()));
        newEmployeeEmployeeWorkAreasService.deleteOne(3L);
        EmployeeEmployeeWorkAreas emwas =new EmployeeEmployeeWorkAreas();
        newEmployeeEmployeeWorkAreasService.create(emwas);
        emwas.setId(4L);


        System.out.println();
        System.out.println();
        System.out.println();

        //EmployeeLaboratoryTools class implementation and service creation
        AbstracDao<EmployeeLaboratoryTools> employeeLaboratoryToolImpl =new EmployeeLaboratoryToolsRepositoryImpl();
        EmployeeLaboratoryToolsService newEmployeeLaboratoryToolService =new EmployeeLaboratoryToolsService(employeeLaboratoryToolImpl);


        //Usage of the service
        EmployeeLaboratoryTools emlt=newEmployeeLaboratoryToolService.findOne(1L);
        LOGGER.info(emlt.toString());
        List<EmployeeLaboratoryTools> emltList= newEmployeeLaboratoryToolService.findAll();
        emltList.forEach(x->LOGGER.info(x.toString()));
        EmployeeLaboratoryTools emlt1=new EmployeeLaboratoryTools();
        newEmployeeLaboratoryToolService.create(emlt1);
        newEmployeeLaboratoryToolService.deleteOne(4L);


    }
}