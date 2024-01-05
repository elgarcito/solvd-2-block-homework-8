package com.solvd.essay.service;

import com.solvd.essay.domain.*;
import com.solvd.essay.persistence.jdbcImpl.*;

import java.sql.SQLException;
import java.util.List;

public class LabTestReportService {
    private final AbstracDao<LabTestReport> labTestReportRepositoryImpl =new LabTestReportRepositoryImpl();

    public void create(LabTestReport labTestReport){
            labTestReportRepositoryImpl.create(labTestReport);
    }
    public List<LabTestReport> findAll() throws SQLException {
        List<LabTestReport> labTestReportList= labTestReportRepositoryImpl.getAll();
        /*

        AbstracDao<EquipmentForTestModel> equipmentForTestModelImpl= new EquipmentForTestModelRepositoryImpl();
        EquipmentForTestModelService newEquipmentForTestModelService= new EquipmentForTestModelService(equipmentForTestModelImpl);

        AbstracDao<BatchInfo> newBatchInfoImplementation= new BatchInfoRepositoryImpl();
        BatchInfoService newBatchInfoService= new BatchInfoService(newBatchInfoImplementation);

        AbstracDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl();
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstracDao<EssayModule> newEssayModuleImplementation = new EssayModuleRepositoryImpl();
        EssayModuleService newEssayModuleService= new EssayModuleService(newEssayModuleImplementation);

        for (LabTestReport labTestReport: labTestReportList) {
            labTestReport.setEquipmentForTestModel(newEquipmentForTestModelService.findOne(labTestReport.getEquipmentForTestModelId()));
            labTestReport.setBatchInfo(newBatchInfoService.findOne(labTestReport.getBatchInfoId()));
            labTestReport.setEmployee(newEmployeeService.findOne(labTestReport.getEmployeeId()));
            labTestReport.setEssayModule(newEssayModuleService.findOne(labTestReport.getEssayModuleId()));
        }

         */
            return labTestReportList;
    }

    public LabTestReport findOne(Long id) throws SQLException {

        LabTestReport labTestReport= labTestReportRepositoryImpl.findById(id);

        if (labTestReport==null){
            return new LabTestReport();
        }
        /*
        AbstracDao<EquipmentForTestModel> equipmentForTestModelImpl= new EquipmentForTestModelRepositoryImpl();
        EquipmentForTestModelService newEquipmentForTestModelService= new EquipmentForTestModelService(equipmentForTestModelImpl);

        AbstracDao<BatchInfo> newBatchInfoImplementation= new BatchInfoRepositoryImpl();
        BatchInfoService newBatchInfoService= new BatchInfoService(newBatchInfoImplementation);

        AbstracDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl();
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

          AbstracDao<EssayModule> newEssayModuleImplementation = new EssayModuleRepositoryImpl();
        EssayModuleService newEssayModuleService= new EssayModuleService(newEssayModuleImplementation);

         */





        /*

        labTestReport.setEquipmentForTestModel(newEquipmentForTestModelService.findOne(labTestReport.getEquipmentForTestModelId()));
        labTestReport.setBatchInfo(newBatchInfoService.findOne(labTestReport.getBatchInfoId()));
        labTestReport.setEmployee(newEmployeeService.findOne(labTestReport.getEmployeeId()));
        labTestReport.setEssayModule(newEssayModuleService.findOne(labTestReport.getEssayModuleId()));
         */




        return labTestReport;
    }

    public void deleteOne(Long id) throws SQLException {
        labTestReportRepositoryImpl.deleteById(id);
    }


    public void updateEntity(LabTestReport labTestReport,Long id){
        try {
            labTestReportRepositoryImpl.updateById(labTestReport, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
