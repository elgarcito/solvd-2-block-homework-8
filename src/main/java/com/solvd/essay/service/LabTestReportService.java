package com.solvd.essay.service;

import com.solvd.essay.domain.*;
import com.solvd.essay.persistence.impl.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LabTestReportService {
    private final AbstractDao<LabTestReport> labTestReportImpl;

    public LabTestReportService(AbstractDao<LabTestReport> labTestReportAbstractDao){
        this.labTestReportImpl = labTestReportAbstractDao;
    }

    public void create(LabTestReport labTestReport){
        try {
            labTestReportImpl.create(labTestReport);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<LabTestReport> findAll(Connection conn) throws SQLException {
        List<LabTestReport> labTestReportList=labTestReportImpl.getAll();

        AbstractDao<EquipmentForTestModel> equipmentForTestModelImpl= new EquipmentForTestModelRepositoryImpl(conn);
        EquipmentForTestModelService newEquipmentForTestModelService= new EquipmentForTestModelService(equipmentForTestModelImpl);


        AbstractDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl(conn);
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstractDao<EssayModule> newEssayModuleImplementation = new EssayModuleRepositoryImpl(conn);
        EssayModuleService newEssayModuleService= new EssayModuleService(newEssayModuleImplementation);

        for (LabTestReport labTestReport: labTestReportList) {
            labTestReport.setEquipmentForTestModel(newEquipmentForTestModelService.findOne(labTestReport.getEquipmentForTestModelId()));

            labTestReport.setEmployee(newEmployeeService.findOne(labTestReport.getEmployeeId()));
            labTestReport.setEssayModule(newEssayModuleService.findOne(labTestReport.getEssayModuleId()));
        }
            return labTestReportList;
    }

    public LabTestReport findOne(Long id,Connection conn) throws SQLException {

        LabTestReport labTestReport=labTestReportImpl.findById(id);

        AbstractDao<EquipmentForTestModel> equipmentForTestModelImpl= new EquipmentForTestModelRepositoryImpl(conn);
        EquipmentForTestModelService newEquipmentForTestModelService= new EquipmentForTestModelService(equipmentForTestModelImpl);



        AbstractDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl(conn);
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstractDao<EssayModule> newEssayModuleImplementation = new EssayModuleRepositoryImpl(conn);
        EssayModuleService newEssayModuleService= new EssayModuleService(newEssayModuleImplementation);

        labTestReport.setEquipmentForTestModel(newEquipmentForTestModelService.findOne(labTestReport.getEquipmentForTestModelId()));
        labTestReport.setEmployee(newEmployeeService.findOne(labTestReport.getEmployeeId()));
        labTestReport.setEssayModule(newEssayModuleService.findOne(labTestReport.getEssayModuleId()));

        return labTestReport;
    }

    public void deleteOne(Long id) throws SQLException {
        labTestReportImpl.deleteById(id);
    }

    public void deleteEntity(LabTestReport labTestReport){
        labTestReportImpl.delete(labTestReport);
    }

    public void updateEntity(LabTestReport labTestReport){
        try {
            labTestReportImpl.update(labTestReport);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
