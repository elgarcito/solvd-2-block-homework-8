package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.EssayModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EssayModuleRepositoryImpl extends AbstracDao<EssayModule> {
    public EssayModuleRepositoryImpl(Connection conn) {
        super(conn);
    }



    @Override
    public String getTableName() {
        return "essay_module";
    }


    @Override
    public String getTableFields() {
        return "module_description";
    }

    @Override
    public String getThingFields(EssayModule essayModule) {
        return essayModule.getModuleDescription();
    }

    @Override
    public EssayModule mapResultToObject(ResultSet resultSet) throws SQLException {

        EssayModule newEssayModule= new EssayModule();
        newEssayModule.setId(resultSet.getLong("id"));
        newEssayModule.setModuleDescription(resultSet.getString("module_description"));
        return newEssayModule;
    }

    @Override
    public Long getThingId(EssayModule thing) {
        return thing.getId();
    }

    @Override
    protected String getUpdateQuery(EssayModule newEssayModule) {
        return "update essay_module set module_description=\""+newEssayModule.getModuleDescription()+
                "\" where id="+newEssayModule.getId();
    }
}
