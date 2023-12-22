package com.solvd.essay.persistence.impl;

import com.solvd.essay.persistence.InterfaceGenerericDao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstracDao<T> implements InterfaceGenerericDao<T> {
    public Connection conn;

    public AbstracDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void create(T thingToCreate) throws SQLException {
        try {
            conn.setAutoCommit(false);
            if(thingToCreate==null){
                throw new RuntimeException("No null entity can be added");
            }
            String query="insert into "+getTableName( thingToCreate )+"("+getTableFields()+")" +"values (?)";
            PreparedStatement ps =conn.prepareStatement(query);
            ps.setString(1, getThingFields(thingToCreate));
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            conn.rollback();
        }
        finally {
            conn.setAutoCommit(true);
        }
    }

    public abstract String getTableName(T thing);
    public abstract String getTableFields();
    public abstract String getThingFields(T thing);

}
