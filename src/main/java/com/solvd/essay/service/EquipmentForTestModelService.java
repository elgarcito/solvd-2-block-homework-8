package com.solvd.essay.service;

import com.solvd.essay.domain.EquipmentForTestModel;
import com.solvd.essay.persistence.Factory;
import com.solvd.essay.persistence.InterfaceGenericDao;
import com.solvd.essay.persistence.myBatisImpl.EquipmentForTestModelRepositoryImpl;
//import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
//import com.solvd.essay.persistence.jdbcImpl.EquipmentForTestModelRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EquipmentForTestModelService {
    final InterfaceGenericDao<EquipmentForTestModel> equipmentForTestModelRepositoryImpl = Factory.getEquipmentForTestModelRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());
    public void create(EquipmentForTestModel equipmentForTestModel) throws SQLException {
            equipmentForTestModelRepositoryImpl.create(equipmentForTestModel);
    }
    public List<EquipmentForTestModel> findAll() throws SQLException {
            return equipmentForTestModelRepositoryImpl.getAll();
    }

    public EquipmentForTestModel findOne(Long id) throws SQLException {
        EquipmentForTestModel result= equipmentForTestModelRepositoryImpl.findById(id);
        if (result==null){
            return new EquipmentForTestModel();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        equipmentForTestModelRepositoryImpl.deleteById(id);
    }


    public void updateEntity(EquipmentForTestModel equipmentForTestModel,Long id){
        try {
            equipmentForTestModelRepositoryImpl.updateById(equipmentForTestModel, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
