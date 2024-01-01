package com.solvd.essay.service;

import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.EmployeeWorkAreaRepositoryImpl;
import com.solvd.essay.persistence.impl.EssayModuleRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EssayModuleService {
    private static final Logger LOGGER = LogManager.getLogger(EssayModuleRepositoryImpl.class);
    private final EssayModuleRepositoryImpl essayModuleRepositoryImpl=new EssayModuleRepositoryImpl();

    public void create(EssayModule essayModule){
        try {
            essayModuleRepositoryImpl.create(essayModule);
            LOGGER.info("Object added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EssayModule> findAll() throws SQLException {
        List<EssayModule> list=essayModuleRepositoryImpl.getAll();
        LOGGER.info("List returned successfully");
            return list;
    }

    public Optional<EssayModule> findOne(Long id) throws SQLException {
        return Optional.ofNullable(essayModuleRepositoryImpl.findById(id));
    }

    public void deleteOne(Long id) throws SQLException {
        essayModuleRepositoryImpl.deleteById(id);
        LOGGER.info("Object deleted successfully");
    }

    public void updateEntity(EssayModule essayModule,Long id){
        try {
            essayModuleRepositoryImpl.updateById(essayModule,id);
            LOGGER.info("Object updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
