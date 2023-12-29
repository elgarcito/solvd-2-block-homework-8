package com.solvd.essay.service;

import com.solvd.essay.domain.GasConsumptionEssay;
import com.solvd.essay.persistence.impl.AbstracDao;

import java.sql.SQLException;
import java.util.List;

public class GasConsumptionEssayService {
    private final AbstracDao<GasConsumptionEssay> gasConsumptionEssayImpl;

    public GasConsumptionEssayService(AbstracDao<GasConsumptionEssay> gasConsumptionEssayAbstracDao){
        this.gasConsumptionEssayImpl =gasConsumptionEssayAbstracDao;
    }

    public void create(GasConsumptionEssay gasConsumptionEssay){
        try {
            gasConsumptionEssayImpl.create(gasConsumptionEssay);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<GasConsumptionEssay> findAll() throws SQLException {
            return gasConsumptionEssayImpl.getAll();
    }

    public GasConsumptionEssay findOne(Long id) throws SQLException {
        return gasConsumptionEssayImpl.findById(id);
    }

    public void deleteOne(Long id) throws SQLException {
        gasConsumptionEssayImpl.deleteById(id);
    }

    public void deleteEntity(GasConsumptionEssay gasConsumptionEssay){
        gasConsumptionEssayImpl.delete(gasConsumptionEssay);
    }

    public void updateEntity(GasConsumptionEssay gasConsumptionEssay){
        try {
            gasConsumptionEssayImpl.update(gasConsumptionEssay);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
