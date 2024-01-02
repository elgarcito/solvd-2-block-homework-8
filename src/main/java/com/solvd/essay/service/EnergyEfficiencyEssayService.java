package com.solvd.essay.service;

import com.solvd.essay.domain.EnergyEfficiencyEssay;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.EnergyEfficiencyEssayRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EnergyEfficiencyEssayService {
    private static final Logger LOGGER = LogManager.getLogger(EnergyEfficiencyEssayService.class);
    private final EnergyEfficiencyEssayRepositoryImpl energyEfficiencyEssayRepositoryImpl= new EnergyEfficiencyEssayRepositoryImpl();

    public void create(EnergyEfficiencyEssay energyEfficiencyEssay){
        try {
            energyEfficiencyEssayRepositoryImpl.create(energyEfficiencyEssay);
            LOGGER.info("Object added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EnergyEfficiencyEssay> findAll() throws SQLException {
        List<EnergyEfficiencyEssay> eeList= energyEfficiencyEssayRepositoryImpl.getAll();
        LOGGER.info("List returned successfully");
            return eeList;
    }

    public EnergyEfficiencyEssay findOne(Long id) throws SQLException {
        EnergyEfficiencyEssay essay= energyEfficiencyEssayRepositoryImpl.findById(id);

        return essay;
    }

    public void deleteOne(Long id) throws SQLException {
        energyEfficiencyEssayRepositoryImpl.deleteById(id);
        LOGGER.info("Object deleted successfully");
    }


    public void updateEntity(EnergyEfficiencyEssay energyEfficiencyEssay,Long id){
        try {
            energyEfficiencyEssayRepositoryImpl.updateById(energyEfficiencyEssay,id);
            LOGGER.info("Object updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
