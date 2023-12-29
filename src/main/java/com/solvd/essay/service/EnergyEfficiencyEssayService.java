package com.solvd.essay.service;

import com.solvd.essay.domain.EnergyEfficiencyEssay;
import com.solvd.essay.persistence.impl.AbstracDao;

import java.sql.SQLException;
import java.util.List;

public class EnergyEfficiencyEssayService {
    private final AbstracDao<EnergyEfficiencyEssay> energyEfficiencyEssayImpl;

    public EnergyEfficiencyEssayService(AbstracDao<EnergyEfficiencyEssay> energyEfficiencyEssayAbstracDao){
        this.energyEfficiencyEssayImpl =energyEfficiencyEssayAbstracDao;
    }

    public void create(EnergyEfficiencyEssay energyEfficiencyEssay){
        try {
            energyEfficiencyEssayImpl.create(energyEfficiencyEssay);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EnergyEfficiencyEssay> findAll() throws SQLException {
            return energyEfficiencyEssayImpl.getAll();
    }

    public EnergyEfficiencyEssay findOne(Long id) throws SQLException {
        return energyEfficiencyEssayImpl.findById(id);
    }

    public void deleteOne(Long id) throws SQLException {
        energyEfficiencyEssayImpl.deleteById(id);
    }

    public void deleteEntity(EnergyEfficiencyEssay energyEfficiencyEssay){
        energyEfficiencyEssayImpl.delete(energyEfficiencyEssay);
    }

    public void updateEntity(EnergyEfficiencyEssay energyEfficiencyEssay){
        try {
            energyEfficiencyEssayImpl.update(energyEfficiencyEssay);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
