package com.solvd.essay.service;

import com.solvd.essay.domain.EquipmentForTestModel;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.EquipmentForTestModelRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EquipmentForTestModelService {
    private final AbstracDao<EquipmentForTestModel> equipmentForTestModelImpl= new EquipmentForTestModelRepositoryImpl();

    public void create(EquipmentForTestModel equipmentForTestModel){
        try {
            equipmentForTestModelImpl.create(equipmentForTestModel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EquipmentForTestModel> findAll() throws SQLException {
            return equipmentForTestModelImpl.getAll();
    }

    public EquipmentForTestModel findOne(Long id) throws SQLException {
        EquipmentForTestModel result= equipmentForTestModelImpl.findById(id);
        if (result==null){
            return new EquipmentForTestModel();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        equipmentForTestModelImpl.deleteById(id);
    }

    public void deleteEntity(EquipmentForTestModel equipmentForTestModel){
        equipmentForTestModelImpl.delete(equipmentForTestModel);
    }

    public void updateEntity(EquipmentForTestModel equipmentForTestModel,Long id){
        try {
            equipmentForTestModelImpl.update(equipmentForTestModel, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
