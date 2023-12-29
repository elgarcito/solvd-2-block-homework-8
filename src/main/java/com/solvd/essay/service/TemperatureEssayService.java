package com.solvd.essay.service;

import com.solvd.essay.domain.TemperatureEssay;
import com.solvd.essay.persistence.impl.AbstracDao;

import java.sql.SQLException;
import java.util.List;

public class TemperatureEssayService {
    private final AbstracDao<TemperatureEssay> temperatureEssayImpl;

    public TemperatureEssayService(AbstracDao<TemperatureEssay> temperatureEssayAbstracDao){
        this.temperatureEssayImpl =temperatureEssayAbstracDao;
    }

    public void create(TemperatureEssay temperatureEssay){
        try {
            temperatureEssayImpl.create(temperatureEssay);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<TemperatureEssay> findAll() throws SQLException {
            return temperatureEssayImpl.getAll();
    }

    public TemperatureEssay findOne(Long id) throws SQLException {
        return temperatureEssayImpl.findById(id);
    }

    public void deleteOne(Long id) throws SQLException {
        temperatureEssayImpl.deleteById(id);
    }

    public void deleteEntity(TemperatureEssay temperatureEssay){
        temperatureEssayImpl.delete(temperatureEssay);
    }

    public void updateEntity(TemperatureEssay temperatureEssay){
        try {
            temperatureEssayImpl.update(temperatureEssay);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
