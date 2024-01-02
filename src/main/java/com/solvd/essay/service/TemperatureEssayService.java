package com.solvd.essay.service;

import com.solvd.essay.domain.TemperatureEssay;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.TemperatureEssayRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TemperatureEssayService  {
    private final TemperatureEssayRepositoryImpl temperatureEssayRepositoryImpl=new TemperatureEssayRepositoryImpl();
    private static final Logger LOGGER = LogManager.getLogger(TemperatureEssayService.class);

    public void create(TemperatureEssay temperatureEssay){
        try {
            temperatureEssayRepositoryImpl.create(temperatureEssay);
            LOGGER.info("Object added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<TemperatureEssay> findAll() throws SQLException {
        List<TemperatureEssay> temperatureEssaysList= temperatureEssayRepositoryImpl.getAll();
        LOGGER.info("List returned successfully");
            return temperatureEssaysList;
    }

    public TemperatureEssay findOne(Long id) throws SQLException {
        TemperatureEssay essay= temperatureEssayRepositoryImpl.findById(id);

        return  essay;
    }

    public void deleteOne(Long id) throws SQLException {
        temperatureEssayRepositoryImpl.deleteById(id);
        LOGGER.info("Object deleted successfully");
    }

    public void updateEntity(TemperatureEssay temperatureEssay, Long id){
        try {
            temperatureEssayRepositoryImpl.updateById(temperatureEssay,id);
            LOGGER.info("Object updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
