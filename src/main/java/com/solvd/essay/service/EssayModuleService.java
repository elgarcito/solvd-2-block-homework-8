package com.solvd.essay.service;

import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.patterns.factoryPattern.ImplementationFactory;
import com.solvd.essay.persistence.InterfaceGenericDao;
//import com.solvd.essay.persistence.jdbcImpl.AbstractDao;
//import com.solvd.essay.persistence.jdbcImpl.EssayModuleRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EssayModuleService {
    final InterfaceGenericDao<EssayModule> essayModuleRepositoryImpl = ImplementationFactory.getEssayModuleRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());
    public void create(EssayModule essayModule) throws SQLException {
            essayModuleRepositoryImpl.create(essayModule);
    }
    public List<EssayModule> findAll() throws SQLException {
            return essayModuleRepositoryImpl.getAll();
    }

    public EssayModule findOne(Long id) throws SQLException {
        EssayModule result= essayModuleRepositoryImpl.findById(id);
        if (result==null){
            return new EssayModule();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        essayModuleRepositoryImpl.deleteById(id);
    }


    public void updateEntity(EssayModule essayModule, Long id){
        try {
            essayModuleRepositoryImpl.updateById(essayModule,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
