package com.solvd.essay.service;

import com.solvd.essay.domain.LabTestReport;
import com.solvd.essay.persistence.impl.AbstracDao;

import java.sql.SQLException;
import java.util.List;

public class LabTestReportService {
    private final AbstracDao<LabTestReport> labTestReportImpl;

    public LabTestReportService(AbstracDao<LabTestReport> labTestReportAbstracDao){
        this.labTestReportImpl =labTestReportAbstracDao;
    }

    public void create(LabTestReport labTestReport){
        try {
            labTestReportImpl.create(labTestReport);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<LabTestReport> findAll() throws SQLException {
            return labTestReportImpl.getAll();
    }

    public LabTestReport findOne(Long id) throws SQLException {
        return labTestReportImpl.findById(id);
    }

    public void deleteOne(Long id) throws SQLException {
        labTestReportImpl.deleteById(id);
    }

    public void deleteEntity(LabTestReport labTestReport){
        labTestReportImpl.delete(labTestReport);
    }

    public void updateEntity(LabTestReport labTestReport){
        try {
            labTestReportImpl.update(labTestReport);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
