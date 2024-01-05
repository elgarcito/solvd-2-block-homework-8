package com.solvd.essay.service;

import com.solvd.essay.domain.TemperatureEssay;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.TemperatureEssayRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class TemperatureEssayService {
    private final AbstracDao<TemperatureEssay> temperatureEssayRepositoryImpl = new TemperatureEssayRepositoryImpl();

    public void create(TemperatureEssay temperatureEssay){
            temperatureEssayRepositoryImpl.create(temperatureEssay);

    }
    public List<TemperatureEssay> findAll() throws SQLException {
        List<TemperatureEssay> temperatureEssaysList= temperatureEssayRepositoryImpl.getAll();
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
        TemperatureEssay essay= temperatureEssayRepositoryImpl.findById(id);
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
        temperatureEssayRepositoryImpl.deleteById(id);
    }

    public void updateEntity(TemperatureEssay temperatureEssay, Long id){
        try {
            temperatureEssayRepositoryImpl.updateById(temperatureEssay,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
