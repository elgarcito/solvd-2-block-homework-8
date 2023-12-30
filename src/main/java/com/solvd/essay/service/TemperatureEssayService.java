package com.solvd.essay.service;

import com.solvd.essay.domain.LabTestReport;
import com.solvd.essay.domain.TemperatureEssay;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.LabTestReportRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TemperatureEssayService {
    private final AbstractDao<TemperatureEssay> temperatureEssayImpl;

    public TemperatureEssayService(AbstractDao<TemperatureEssay> temperatureEssayAbstractDao){
        this.temperatureEssayImpl = temperatureEssayAbstractDao;
    }

    public void create(TemperatureEssay temperatureEssay){
        try {
            temperatureEssayImpl.create(temperatureEssay);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<TemperatureEssay> findAll(Connection conn) throws SQLException {
        List<TemperatureEssay> temperatureEssaysList=temperatureEssayImpl.getAll();
        AbstractDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl(conn);
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        for (TemperatureEssay tempEssay:temperatureEssaysList) {
            tempEssay.setLabTestReport(newLabTestReportService.findOne(tempEssay.getLabTestReportId(),conn));
        }
            return temperatureEssaysList;
    }

    public TemperatureEssay findOne(Long id,Connection conn) throws SQLException {
        TemperatureEssay essay=temperatureEssayImpl.findById(id);
        AbstractDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl(conn);
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        essay.setLabTestReport(newLabTestReportService.findOne(essay.getLabTestReportId(),conn));
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
