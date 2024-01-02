package com.solvd.essay.service;

import com.solvd.essay.domain.EnergyEfficiencyEssay;
import com.solvd.essay.domain.LabTestReport;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.LabTestReportRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EnergyEfficiencyEssayService {
    private final AbstractDao<EnergyEfficiencyEssay> energyEfficiencyEssayImpl;

    public EnergyEfficiencyEssayService(AbstractDao<EnergyEfficiencyEssay> energyEfficiencyEssayAbstractDao){
        this.energyEfficiencyEssayImpl = energyEfficiencyEssayAbstractDao;
    }

    public void create(EnergyEfficiencyEssay energyEfficiencyEssay){
        try {
            energyEfficiencyEssayImpl.create(energyEfficiencyEssay);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EnergyEfficiencyEssay> findAll(Connection conn) throws SQLException {
        List<EnergyEfficiencyEssay> eeList=energyEfficiencyEssayImpl.getAll();

        for (EnergyEfficiencyEssay enEfEssay:eeList) {
        }
            return eeList;
    }

    public EnergyEfficiencyEssay findOne(Long id ,Connection conn) throws SQLException {
        EnergyEfficiencyEssay essay= energyEfficiencyEssayImpl.findById(id);

        return essay;
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
