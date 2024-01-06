package com.solvd.essay.service;

import com.solvd.essay.domain.EnergyEfficiencyEssay;
import com.solvd.essay.persistence.Factory;
import com.solvd.essay.persistence.InterfaceGenericDao;


import java.sql.SQLException;
import java.util.List;

public class EnergyEfficiencyEssayService {
    final InterfaceGenericDao<EnergyEfficiencyEssay> energyEfficiencyEssayRepositoryImpl = Factory.getEnergyEfficiencyEssayRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());
    public void create(EnergyEfficiencyEssay energyEfficiencyEssay) throws SQLException {
        energyEfficiencyEssayRepositoryImpl.create(energyEfficiencyEssay);
    }
    public List<EnergyEfficiencyEssay> findAll() throws SQLException {
        List<EnergyEfficiencyEssay> eeList= energyEfficiencyEssayRepositoryImpl.getAll();
            return eeList;
    }

    public EnergyEfficiencyEssay findOne(Long id) throws SQLException {
        EnergyEfficiencyEssay essay= energyEfficiencyEssayRepositoryImpl.findById(id);
        if (essay==null){
            return new EnergyEfficiencyEssay();
        }
        /*
        AbstractDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
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
