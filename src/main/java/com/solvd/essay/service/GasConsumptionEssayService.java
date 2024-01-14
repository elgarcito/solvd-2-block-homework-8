package com.solvd.essay.service;

import com.solvd.essay.domain.GasConsumptionEssay;
import com.solvd.essay.patterns.factoryPattern.ImplementationFactory;
import com.solvd.essay.persistence.InterfaceGenericDao;
//import com.solvd.essay.persistence.jdbcImpl.AbstractDao;
//import com.solvd.essay.persistence.jdbcImpl.GasConsumptionEssayRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class GasConsumptionEssayService {
    final InterfaceGenericDao<GasConsumptionEssay> gasConsumptionEssayRepositoryImpl = ImplementationFactory.getGasConsumptionEssayRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());
    public void create(GasConsumptionEssay gasConsumptionEssay) throws SQLException {
            gasConsumptionEssayRepositoryImpl.create(gasConsumptionEssay);
    }
    public List<GasConsumptionEssay> findAll() throws SQLException {
        List<GasConsumptionEssay> listOfGasEssays= gasConsumptionEssayRepositoryImpl.getAll();
        /*
        AbstractDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        for (GasConsumptionEssay gasConEssay:listOfGasEssays) {
            gasConEssay.setLabTestReport(newLabTestReportService.findOne(gasConEssay.getLabTestReportId()));
        }

         */
        return listOfGasEssays;

    }

    public GasConsumptionEssay findOne(Long id) throws SQLException {
        GasConsumptionEssay gasConEssay= gasConsumptionEssayRepositoryImpl.findById(id);
        if (gasConEssay==null){
            return new GasConsumptionEssay();
        }
        /*
        AbstractDao<LabTestReport> labTestReportImpl=new LabTestReportRepositoryImpl();
        LabTestReportService newLabTestReportService= new LabTestReportService(labTestReportImpl);
        gasConEssay.setLabTestReport(newLabTestReportService.findOne(gasConEssay.getLabTestReportId()));

         */
        return gasConEssay;
    }

    public void deleteOne(Long id) throws SQLException {
        gasConsumptionEssayRepositoryImpl.deleteById(id);
    }


    public void updateEntity(GasConsumptionEssay gasConsumptionEssay,Long id){
        try {
            gasConsumptionEssayRepositoryImpl.updateById(gasConsumptionEssay,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
