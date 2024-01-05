package com.solvd.essay.service;

import com.solvd.essay.domain.EquipmentForTestModel;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.EquipmentForTestModelRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EquipmentForTestModelService {
    private final AbstracDao<EquipmentForTestModel> equipmentForTestModelRepositoryImpl = new EquipmentForTestModelRepositoryImpl();

    public void create(EquipmentForTestModel equipmentForTestModel){
        try {
            equipmentForTestModelRepositoryImpl.create(equipmentForTestModel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
