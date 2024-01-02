package com.solvd.essay.service;

import com.solvd.essay.domain.GasConsumptionEssay;
import com.solvd.essay.persistence.impl.AbstractDao;
import com.solvd.essay.persistence.impl.GasConsumptionEssayRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class GasConsumptionEssayService {
    private final GasConsumptionEssayRepositoryImpl gasConsumptionEssayRepositoryImpl= new GasConsumptionEssayRepositoryImpl();
    private static final Logger LOGGER = LogManager.getLogger(GasConsumptionEssayRepositoryImpl.class);

    public void create(GasConsumptionEssay gasConsumptionEssay){
        try {
            gasConsumptionEssayRepositoryImpl.create(gasConsumptionEssay);
            LOGGER.info("Object added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<GasConsumptionEssay> findAll() throws SQLException {
        List<GasConsumptionEssay> listOfGasEssays= gasConsumptionEssayRepositoryImpl.getAll();
        LOGGER.info("List returned successfully");
        return listOfGasEssays;

    }

    public Optional<GasConsumptionEssay> findOne(Long id) throws SQLException {
        GasConsumptionEssay gasConEssay= gasConsumptionEssayRepositoryImpl.findById(id);
        return Optional.ofNullable(gasConEssay);
    }

    public void deleteOne(Long id) throws SQLException {
        gasConsumptionEssayRepositoryImpl.deleteById(id);
        LOGGER.info("Object deleted successfully");
    }


    public void updateEntity(GasConsumptionEssay gasConsumptionEssay,Long id){
        try {
            gasConsumptionEssayRepositoryImpl.updateById(gasConsumptionEssay,id);
            LOGGER.info("Object updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
