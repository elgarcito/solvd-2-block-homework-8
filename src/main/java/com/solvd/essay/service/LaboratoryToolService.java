package com.solvd.essay.service;

import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.LaboratoryToolRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class LaboratoryToolService {
    private final AbstracDao<LaboratoryTool> laboratoryToolImpl= new LaboratoryToolRepositoryImpl();


    public void create(LaboratoryTool laboratoryTool){
        try {
            laboratoryToolImpl.create(laboratoryTool);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<LaboratoryTool> findAll() throws SQLException {
            return laboratoryToolImpl.getAll();
    }

    public LaboratoryTool findOne(Long id) throws SQLException {
        LaboratoryTool result= laboratoryToolImpl.findById(id);
        if (result==null){
            return new LaboratoryTool();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        laboratoryToolImpl.deleteById(id);
    }

    public void deleteEntity(LaboratoryTool laboratoryTool){
        laboratoryToolImpl.delete(laboratoryTool);
    }

    public void updateEntity(LaboratoryTool laboratoryTool,Long id){
        try {
            laboratoryToolImpl.update(laboratoryTool, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
