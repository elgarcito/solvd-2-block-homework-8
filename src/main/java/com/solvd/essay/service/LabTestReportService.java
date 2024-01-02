package com.solvd.essay.service;

import com.solvd.essay.domain.*;
import com.solvd.essay.persistence.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LabTestReportService {
    private static final Logger LOGGER = LogManager.getLogger(LabTestReportService.class);
    private final LabTestReportRepositoryImpl labTestReportRepositoryImpl = new LabTestReportRepositoryImpl();
    public void create(LabTestReport labTestReport){
        try {
            labTestReportRepositoryImpl.create(labTestReport);
            LOGGER.info("Object added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<LabTestReport> findAll() throws SQLException {
        List<LabTestReport> labTestReportList= labTestReportRepositoryImpl.getAll();
        LOGGER.info("List returned successfully");
        return labTestReportList;
    }

    public Optional<LabTestReport> findOne(Long id) throws SQLException {
        LabTestReport labTestReport= labTestReportRepositoryImpl.findById(id);
        return Optional.ofNullable(labTestReport);
    }

    public void deleteOne(Long id) throws SQLException {
        labTestReportRepositoryImpl.deleteById(id);
        LOGGER.info("Object deleted successfully");
    }

    public void updateEntity(LabTestReport labTestReport,Long id){
        try {
            labTestReportRepositoryImpl.updateById(labTestReport,id);
            LOGGER.info("Object updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
