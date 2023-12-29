package com.solvd.essay.service;

import com.solvd.essay.domain.EquipmentForTestModel;
import com.solvd.essay.persistence.impl.AbstracDao;

import java.sql.SQLException;
import java.util.List;

public class EquipmentForTestModelService {
    private final AbstracDao<EquipmentForTestModel> equipmentForTestModelImpl;

    public EquipmentForTestModelService(AbstracDao<EquipmentForTestModel> equipmentForTestModelAbstracDao){
        this.equipmentForTestModelImpl =equipmentForTestModelAbstracDao;
    }

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
        return equipmentForTestModelImpl.findById(id);
    }

    public void deleteOne(Long id) throws SQLException {
        equipmentForTestModelImpl.deleteById(id);
    }

    public void deleteEntity(EquipmentForTestModel equipmentForTestModel){
        equipmentForTestModelImpl.delete(equipmentForTestModel);
    }

    public void updateEntity(EquipmentForTestModel equipmentForTestModel){
        try {
            equipmentForTestModelImpl.update(equipmentForTestModel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
