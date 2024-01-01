package com.solvd.essay.service;

import com.solvd.essay.Main;
import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.persistence.LaboratoryToolRepository;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.LaboratoryToolRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LaboratoryToolService {
    private static final Logger LOGGER = LogManager.getLogger(LaboratoryToolService.class);
    private final LaboratoryToolRepository laboratoryToolRepository=new LaboratoryToolRepositoryImpl();


    public void create(LaboratoryTool laboratoryTool){
        try {
            laboratoryToolRepository.create(laboratoryTool);
            LOGGER.info("Object added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<LaboratoryTool> findAll() throws SQLException {
        List<LaboratoryTool> list=laboratoryToolRepository.getAll();
        LOGGER.info("List returned successfully");
        return list;
    }

    public Optional<LaboratoryTool>  findOne(Long id) throws SQLException {
        return Optional.ofNullable(laboratoryToolRepository.findById(id));
    }

    public void deleteOne(Long id) throws SQLException {
        laboratoryToolRepository.deleteById(id);
        LOGGER.info("Object deleted successfully");
    }

    public void updateEntity(LaboratoryTool laboratoryTool,Long entityId){
        try {
            laboratoryToolRepository.updateById(laboratoryTool,entityId);
            LOGGER.info("Object updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
