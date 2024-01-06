package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.domain.*;
import com.solvd.essay.service.BatchInfoService;
import com.solvd.essay.service.EmployeeService;
import com.solvd.essay.service.EquipmentForTestModelService;
import com.solvd.essay.service.EssayModuleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class LabTestReportRepositoryImpl extends AbstractDao<LabTestReport> {
    private static final Logger LOGGER = LogManager.getLogger(LabTestReportRepositoryImpl.class);
    public LabTestReportRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(LabTestReport newThingToUpdate,Long id) {
        try {
            String updateQuery=String.format("update %s set essay_code=\"%s\" ,date_of_essay=\"%s\",essay_description=\"%s\",equipment_for_test_model_id=%s,batch_info_id=%s,employee_id=%s,essay_module_id=%s where id=%s",
                    getTableName(),newThingToUpdate.getEssayCode(),newThingToUpdate.getDateOfEssay(),
                    newThingToUpdate.getEssayDescription(), newThingToUpdate.getEquipmentForTestModel().getId(),
                    newThingToUpdate.getBatchInfo().getId(),newThingToUpdate.getEmployee().getId(),
                    newThingToUpdate.getEssayModule().getId(),id);
            return updateQuery;
        }catch (NullPointerException e){
            LOGGER.info("The update can't be null in any field");
            return "invalid update";
        }

    }

    @Override
    protected String getTableName() {
        return "lab_test_report";
    }

    @Override
    protected String getTableFields() {
        return "essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id";
    }

    @Override
    protected Long getThingId(LabTestReport thing) {
        return thing.getId();
    }

    @Override
    protected LabTestReport mapResultToObject(ResultSet resultSet, Connection conn) throws SQLException {
        LabTestReport entity=new LabTestReport();
        entity.setId(resultSet.getLong("id"));
        entity.setEssayCode(resultSet.getString("essay_code"));
        entity.setDateOfEssay(resultSet.getDate("date_of_essay").toLocalDate());
        entity.setEssayDescription(resultSet.getString("essay_description"));

        /*
        entity.setEquipmentForTestModelId(resultSet.getLong("equipment_for_test_model_id"));
        entity.setBatchInfoId(resultSet.getLong("batch_info_id"));
        entity.setEmployeeId(resultSet.getLong("employee_id"));
        entity.setEssayModuleId(resultSet.getLong("essay_module_id"));
         */


        EquipmentForTestModelService newEquipmentForTestModelService= new EquipmentForTestModelService();

        entity.setEquipmentForTestModel(newEquipmentForTestModelService.findOne(resultSet.getLong("equipment_for_test_model_id")));

        BatchInfoService newBatchInfoService= new BatchInfoService();

        entity.setBatchInfo(newBatchInfoService.findOne(resultSet.getLong("batch_info_id")));


        EmployeeService newEmployeeService= new EmployeeService();
        entity.setEmployee(newEmployeeService.findOne(resultSet.getLong("employee_id")));

        //AbstractDao<EssayModule> newEssayModuleImplementation = new EssayModuleRepositoryImpl();
        EssayModuleService newEssayModuleService= new EssayModuleService();

        entity.setEssayModule(newEssayModuleService.findOne(resultSet.getLong("essay_module_id")));

        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?,?,?,?,?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, LabTestReport thingToCreate) {
        try {
            ps.setString(1,thingToCreate.getEssayCode());
            ps.setDate(2, Date.valueOf(thingToCreate.getDateOfEssay()));
            ps.setString(3,thingToCreate.getEssayDescription());
            ps.setLong(4,thingToCreate.getEquipmentForTestModel().getId());
            ps.setLong(5,thingToCreate.getBatchInfo().getId());
            ps.setLong(6,thingToCreate.getEmployee().getId());
            ps.setLong(7,thingToCreate.getEssayModule().getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected LabTestReport returnVoidInstance() {
        return new LabTestReport();
    }

    @Override
    protected void saveListInObject(LabTestReport thing, List<LabTestReport> list) {
        thing.setLabTestReportList(list);
    }
}
