package com.solvd.essay.service;

import com.solvd.essay.domain.TemperatureEssay;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.TemperatureEssayRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class TemperatureEssayService {
    private final AbstracDao<TemperatureEssay> temperatureEssayImpl= new TemperatureEssayRepositoryImpl();

    public void create(TemperatureEssay temperatureEssay){
        try {
            temperatureEssayImpl.create(temperatureEssay);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<TemperatureEssay> findAll() throws SQLException {
        List<TemperatureEssay> temperatureEssaysList=temperatureEssayImpl.getAll();
        /*
        AbstracDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        for (TemperatureEssay tempEssay:temperatureEssaysList) {
            tempEssay.setLabTestReport(newLabTestReportService.findOne(tempEssay.getLabTestReportId()));
        }

         */
            return temperatureEssaysList;
    }

    public TemperatureEssay findOne(Long id) throws SQLException {
        TemperatureEssay essay=temperatureEssayImpl.findById(id);
        if (essay==null){
            return new TemperatureEssay();
        }
        /*
        AbstracDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        essay.setLabTestReport(newLabTestReportService.findOne(essay.getLabTestReportId()));

         */
        return  essay;
    }

    public void deleteOne(Long id) throws SQLException {
        temperatureEssayImpl.deleteById(id);
    }

    public void deleteEntity(TemperatureEssay temperatureEssay){
        temperatureEssayImpl.delete(temperatureEssay);
    }

    public void updateEntity(TemperatureEssay temperatureEssay, Long id){
        try {
            temperatureEssayImpl.update(temperatureEssay,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
