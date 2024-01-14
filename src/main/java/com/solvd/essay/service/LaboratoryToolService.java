package com.solvd.essay.service;

import com.solvd.essay.domain.LaboratoryTool;
import com.solvd.essay.patterns.factoryPattern.ImplementationFactory;
import com.solvd.essay.persistence.InterfaceGenericDao;
//import com.solvd.essay.persistence.jdbcImpl.AbstractDao;
//import com.solvd.essay.persistence.jdbcImpl.LaboratoryToolRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class LaboratoryToolService {
    final InterfaceGenericDao<LaboratoryTool> laboratoryToolRepositoryImpl = ImplementationFactory.getLaboratoryToolRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());
    public void create(LaboratoryTool laboratoryTool) throws SQLException {
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
