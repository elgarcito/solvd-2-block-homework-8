package com.solvd.essay.service;

import com.solvd.essay.domain.EnergyEfficiencyEssay;
import com.solvd.essay.domain.GasConsumptionEssay;
import com.solvd.essay.domain.LabTestReport;
import com.solvd.essay.domain.TemperatureEssay;
import com.solvd.essay.persistence.impl.AbstracDao;
import com.solvd.essay.persistence.impl.LabTestReportRepositoryImpl;

import java.sql.Connection;
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
        List<TemperatureEssay> temperatureEssaysList=temperatureEssayImpl.getAll();
        AbstracDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        for (TemperatureEssay tempEssay:temperatureEssaysList) {
            tempEssay.setLabTestReport(newLabTestReportService.findOne(tempEssay.getLabTestReportId()));
        }
            return temperatureEssaysList;
    }

    public TemperatureEssay findOne(Long id) throws SQLException {
        TemperatureEssay essay=temperatureEssayImpl.findById(id);
        if (essay==null){
            return new TemperatureEssay();
        }
        AbstracDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        essay.setLabTestReport(newLabTestReportService.findOne(essay.getLabTestReportId()));
        return  essay;
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
