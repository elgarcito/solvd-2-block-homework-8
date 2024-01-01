package com.solvd.essay.service;

import com.solvd.essay.domain.*;
import com.solvd.essay.persistence.impl.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LabTestReportService {
    private final AbstractDao<LabTestReport> labTestReportImpl;

    public LabTestReportService(AbstractDao<LabTestReport> labTestReportAbstractDao){
        this.labTestReportImpl = labTestReportAbstractDao;
    }

    public void create(LabTestReport labTestReport){
        try {
            labTestReportImpl.create(labTestReport);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<LabTestReport> findAll(Connection conn) throws SQLException {
        List<LabTestReport> labTestReportList=labTestReportImpl.getAll();






        for (LabTestReport labTestReport: labTestReportList) {

        }
            return labTestReportList;
    }

    public LabTestReport findOne(Long id,Connection conn) throws SQLException {

        LabTestReport labTestReport=labTestReportImpl.findById(id);



        return labTestReport;
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
