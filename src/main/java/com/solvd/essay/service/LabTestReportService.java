package com.solvd.essay.service;

import com.solvd.essay.domain.*;
import com.solvd.essay.persistence.Factory;
import com.solvd.essay.persistence.InterfaceGenericDao;


import java.sql.SQLException;
import java.util.List;

public class LabTestReportService {
    final InterfaceGenericDao<LabTestReport> labTestReportRepositoryImpl = Factory.getLabTestReportRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());
    public void create(LabTestReport labTestReport) throws SQLException {
            labTestReportRepositoryImpl.create(labTestReport);
    }
    public List<LabTestReport> findAll() throws SQLException {
        List<LabTestReport> labTestReportList= labTestReportRepositoryImpl.getAll();
            return labTestReportList;
    }

    public LabTestReport findOne(Long id) throws SQLException {

        LabTestReport labTestReport= labTestReportRepositoryImpl.findById(id);

        if (labTestReport==null){
            return new LabTestReport();
        }
        /*
        AbstractDao<EquipmentForTestModel> equipmentForTestModelImpl= new EquipmentForTestModelRepositoryImpl();
        EquipmentForTestModelService newEquipmentForTestModelService= new EquipmentForTestModelService(equipmentForTestModelImpl);

        AbstractDao<BatchInfo> newBatchInfoImplementation= new BatchInfoRepositoryImpl();
        BatchInfoService newBatchInfoService= new BatchInfoService(newBatchInfoImplementation);

        AbstractDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl();
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

          AbstractDao<EssayModule> newEssayModuleImplementation = new EssayModuleRepositoryImpl();
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
