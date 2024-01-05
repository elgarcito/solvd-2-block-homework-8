package com.solvd.essay.service;

import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.LaboratoryToolRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class LaboratoryToolService {
    private final AbstracDao<LaboratoryTool> laboratoryToolRepositoryImpl = new LaboratoryToolRepositoryImpl();


    public void create(LaboratoryTool laboratoryTool){
            laboratoryToolRepositoryImpl.create(laboratoryTool);
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


    public void updateEntity(LaboratoryTool laboratoryTool,Long id){
        try {
            laboratoryToolRepositoryImpl.updateById(laboratoryTool, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
