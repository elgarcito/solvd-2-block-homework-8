package com.solvd.essay.service;

import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
import com.solvd.essay.persistence.jdbcImpl.EssayModuleRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EssayModuleService {
    private final AbstracDao<EssayModule> essayModuleImpl=new EssayModuleRepositoryImpl();
    public void create(EssayModule essayModule){
        try {
            essayModuleImpl.create(essayModule);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<EssayModule> findAll() throws SQLException {
            return essayModuleImpl.getAll();
    }

    public EssayModule findOne(Long id) throws SQLException {
        EssayModule result= essayModuleImpl.findById(id);
        if (result==null){
            return new EssayModule();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        essayModuleImpl.deleteById(id);
    }

    public void deleteEntity(EssayModule essayModule){
        essayModuleImpl.delete(essayModule);
    }

    public void updateEntity(EssayModule essayModule, Long id){
        try {
            essayModuleImpl.update(essayModule,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
