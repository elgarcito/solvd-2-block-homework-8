package com.solvd.essay.service;

import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.impl.AbstracDao;

import java.sql.SQLException;

public class EssayModuleService {
    private final AbstracDao<EssayModule> essayModuleImpl;

    public EssayModuleService(AbstracDao<EssayModule> essayModuleAbstracDao){
        this.essayModuleImpl =essayModuleAbstracDao;
    }

    public void create(EssayModule essayModule){
        try {
            essayModuleImpl.create(essayModule);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
