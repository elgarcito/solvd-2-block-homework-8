package com.solvd.essay.service;

import com.solvd.essay.domain.EquipmentForTestModel;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.EquipmentForTestModelRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EquipmentForTestModelService {
    private final EquipmentForTestModelRepositoryImpl equipmentForTestModelRepositoryImpl=new EquipmentForTestModelRepositoryImpl();

    private static final Logger LOGGER = LogManager.getLogger(EquipmentForTestModelService.class);
    public void create(EquipmentForTestModel equipmentForTestModel){
        try {
            equipmentForTestModelRepositoryImpl.create(equipmentForTestModel);
            LOGGER.info("Object added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EquipmentForTestModel> findAll() throws SQLException {
        List<EquipmentForTestModel> list=equipmentForTestModelRepositoryImpl.getAll();
        LOGGER.info("List returned successfully");
            return list;
    }

    public Optional<EquipmentForTestModel> findOne(Long id) throws SQLException {
        return Optional.ofNullable(equipmentForTestModelRepositoryImpl.findById(id));
    }

    public void deleteOne(Long id) throws SQLException {
        equipmentForTestModelRepositoryImpl.deleteById(id);
        LOGGER.info("Object deleted successfully");
    }


    public void updateEntity(EquipmentForTestModel equipmentForTestModel, Long id){
        try {
            equipmentForTestModelRepositoryImpl.updateById(equipmentForTestModel,id);
            LOGGER.info("Object updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
