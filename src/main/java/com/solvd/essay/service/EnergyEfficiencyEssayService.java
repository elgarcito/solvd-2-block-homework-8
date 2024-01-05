package com.solvd.essay.service;

import com.solvd.essay.domain.EnergyEfficiencyEssay;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.EnergyEfficiencyEssayRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EnergyEfficiencyEssayService {
    private final AbstracDao<EnergyEfficiencyEssay> energyEfficiencyEssayRepositoryImpl = new EnergyEfficiencyEssayRepositoryImpl();

    public void create(EnergyEfficiencyEssay energyEfficiencyEssay){

            energyEfficiencyEssayRepositoryImpl.create(energyEfficiencyEssay);

    }
    public List<EnergyEfficiencyEssay> findAll() throws SQLException {
        List<EnergyEfficiencyEssay> eeList= energyEfficiencyEssayRepositoryImpl.getAll();
        /*
        AbstracDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        for (EnergyEfficiencyEssay enEfEssay:eeList) {
            enEfEssay.setLabTestReport(newLabTestReportService.findOne(enEfEssay.getLabTestReportId()));
        }

         */
            return eeList;
    }

    public EnergyEfficiencyEssay findOne(Long id) throws SQLException {
        EnergyEfficiencyEssay essay= energyEfficiencyEssayRepositoryImpl.findById(id);
        if (essay==null){
            return new EnergyEfficiencyEssay();
        }
        /*
        AbstracDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        essay.setLabTestReport(newLabTestReportService.findOne(essay.getLabTestReportId()));

         */
        return essay;
    }

    public void deleteOne(Long id) throws SQLException {
        energyEfficiencyEssayRepositoryImpl.deleteById(id);
    }



    public void updateEntity(EnergyEfficiencyEssay energyEfficiencyEssay, Long id){
        try {
            energyEfficiencyEssayRepositoryImpl.updateById(energyEfficiencyEssay,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
