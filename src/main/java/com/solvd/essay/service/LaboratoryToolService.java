package com.solvd.essay.service;

import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.LaboratoryToolRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class LaboratoryToolService {
    private final AbstracDao<LaboratoryTool> laboratoryToolRepositoryImpl = new LaboratoryToolRepositoryImpl();


    public void create(LaboratoryTool laboratoryTool){
        try {
            laboratoryToolRepositoryImpl.create(laboratoryTool);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<LaboratoryTool> findAll() throws SQLException {
            return laboratoryToolRepositoryImpl.getAll();
    }

    public LaboratoryTool findOne(Long id) throws SQLException {
        LaboratoryTool result= laboratoryToolRepositoryImpl.findById(id);
        if (result==null){
            return new LaboratoryTool();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        laboratoryToolRepositoryImpl.deleteById(id);
    }

    public void deleteEntity(LaboratoryTool laboratoryTool){
        laboratoryToolRepositoryImpl.delete(laboratoryTool);
    }

    public void updateEntity(LaboratoryTool laboratoryTool,Long id){
        try {
            laboratoryToolRepositoryImpl.update(laboratoryTool, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
