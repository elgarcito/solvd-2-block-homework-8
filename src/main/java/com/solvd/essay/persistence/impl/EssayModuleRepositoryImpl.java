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

        EssayModule entity= new EssayModule();
        entity.setId(resultSet.getLong("id"));
        entity.setModuleDescription(resultSet.getString("module_description"));
        return entity;
    }

    @Override
    public Long getThingId(EssayModule entity) {
        return entity.getId();
    }

    @Override
    protected String getUpdateQuery(EssayModule entity) {
        return "update essay_module set module_description=\""+entity.getModuleDescription()+
                "\" where id="+entity.getId();
    }
}
