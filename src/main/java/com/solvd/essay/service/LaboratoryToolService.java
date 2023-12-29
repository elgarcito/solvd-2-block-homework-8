package com.solvd.essay.service;

import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.persistence.impl.AbstracDao;

import java.sql.SQLException;
import java.util.List;

public class LaboratoryToolService {
    private final AbstracDao<LaboratoryTool> laboratoryToolImpl;

    public LaboratoryToolService(AbstracDao<LaboratoryTool> laboratoryToolAbstracDao){
        this.laboratoryToolImpl =laboratoryToolAbstracDao;
    }

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
        return laboratoryToolImpl.findById(id);
    }

    public void deleteOne(Long id) throws SQLException {
        laboratoryToolImpl.deleteById(id);
    }

    public void deleteEntity(LaboratoryTool laboratoryTool){
        laboratoryToolImpl.delete(laboratoryTool);
    }

    public void updateEntity(LaboratoryTool laboratoryTool){
        try {
            laboratoryToolImpl.update(laboratoryTool);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
