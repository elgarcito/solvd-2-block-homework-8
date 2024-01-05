package com.solvd.essay.service;

import com.solvd.essay.domain.EquipmentForTestModel;
import com.solvd.essay.persistence.myBatisImpl.EquipmentForTestModelRepositoryImpl;
//import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
//import com.solvd.essay.persistence.jdbcImpl.EquipmentForTestModelRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EquipmentForTestModelService {
    //private final AbstracDao<EquipmentForTestModel> equipmentForTestModelRepositoryImpl = new EquipmentForTestModelRepositoryImpl();
    private final EquipmentForTestModelRepositoryImpl equipmentForTestModelRepositoryImpl = new EquipmentForTestModelRepositoryImpl();

    public void create(EquipmentForTestModel equipmentForTestModel){
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
