package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.domain.LaboratoryTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LaboratoryToolRepositoryImpl extends AbstractDao<LaboratoryTool> {
    public LaboratoryToolRepositoryImpl() {
    }

    @Override
    protected String getUpdateQuery(LaboratoryTool newThingToUpdate,Long id) {
        String updateQuery=String.format("update %s set tool_name=\"%s\", tool_description=\"%s\" where id=%s",
                getTableName(),newThingToUpdate.getToolName(),newThingToUpdate.getToolDescription(),id);
        return updateQuery;
    }

    @Override
    protected String getTableName() {
        return "laboratory_tool";
    }

    @Override
    protected String getTableFields() {
        return "tool_name,tool_description";
    }

    @Override
    protected Long getThingId(LaboratoryTool thing) {
        return thing.getId();
    }

    @Override
    protected LaboratoryTool mapResultToObject(ResultSet resultSet, Connection conn) throws SQLException {
        LaboratoryTool entity= new LaboratoryTool();
        entity.setId(resultSet.getLong("id"));
        entity.setToolName(resultSet.getString("tool_name"));
        entity.setToolDescription(resultSet.getString("tool_description"));
        return entity;
    }

    @Override
    protected String getCreateQuery() {
        String createQuery= String.format("insert into %s(%s) value (?,?)",getTableName(),getTableFields());
        return createQuery;
    }

    @Override
    protected void setQueryStatements(PreparedStatement ps, LaboratoryTool thingToCreate) {
        try {
            ps.setString(1,thingToCreate.getToolName());
            ps.setString(2,thingToCreate.getToolDescription());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected LaboratoryTool returnVoidInstance() {
        return new LaboratoryTool();
    }

    @Override
    protected void saveListInObject(LaboratoryTool thing, List<LaboratoryTool> list) {
        thing.setLaboratoryToolList(list);
    }
}
