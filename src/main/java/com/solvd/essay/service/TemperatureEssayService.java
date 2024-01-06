package com.solvd.essay.service;

import com.solvd.essay.domain.TemperatureEssay;
import com.solvd.essay.persistence.Factory;
import com.solvd.essay.persistence.InterfaceGenericDao;
import com.solvd.essay.persistence.myBatisImpl.TemperatureEssayRepositoryImpl;
//import com.solvd.essay.persistence.jdbcImpl.AbstractDao;
//import com.solvd.essay.persistence.jdbcImpl.TemperatureEssayRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class TemperatureEssayService {
    final InterfaceGenericDao<TemperatureEssay> temperatureEssayRepositoryImpl = Factory.getTemperatureEssayRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());
    public void create(TemperatureEssay temperatureEssay) throws SQLException {
            temperatureEssayRepositoryImpl.create(temperatureEssay);

    }
    public List<TemperatureEssay> findAll() throws SQLException {
        List<TemperatureEssay> temperatureEssaysList= temperatureEssayRepositoryImpl.getAll();

            return temperatureEssaysList;
    }

    public TemperatureEssay findOne(Long id) throws SQLException {
        TemperatureEssay essay= temperatureEssayRepositoryImpl.findById(id);
        if (essay==null){
            return new TemperatureEssay();
        }
        /*
        AbstractDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
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
