package com.solvd.essay.service;

import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.impl.AbstractDao;

import java.sql.SQLException;
import java.util.List;

public class EssayModuleService {
    private final AbstractDao<EssayModule> essayModuleImpl;

    public EssayModuleService(AbstractDao<EssayModule> essayModuleAbstractDao){
        this.essayModuleImpl = essayModuleAbstractDao;
    }

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
        return essayModuleImpl.findById(id);
    }

    public void deleteOne(Long id) throws SQLException {
        essayModuleImpl.deleteById(id);
    }

    public void deleteEntity(EssayModule essayModule){
        essayModuleImpl.delete(essayModule);
        /*
        System.out.println("Object with id= "+essayModule.getId()+"and "
                +essayModule.getModuleDescription()+" deleted successfully");
    */
    }

    public void updateEntity(EssayModule essayModule){
        try {
            essayModuleImpl.update(essayModule);
            /*
            System.out.println("Object with id= "+essayModule.getId()+"and "
                    +essayModule.getModuleDescription()+" was updated successfully");
             */
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
