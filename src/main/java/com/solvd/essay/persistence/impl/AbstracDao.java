package com.solvd.essay.persistence.impl;

import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.InterfaceGenerericDao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstracDao<T> implements InterfaceGenerericDao<T> {

    private T newClass;
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
            String query="insert into "+getTableName()+"("+getTableFields()+")" +"values (?)";
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

    @Override
    public List<T> getAll() throws SQLException {
        try {
            conn.setAutoCommit(false);
            String query="select * from "+getTableName();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet result =ps.executeQuery();
            List<T> listOfThings=new ArrayList<>();
            while (result.next()){
                newClass = mapResultToObject(result);
                listOfThings.add(newClass);
            }
            return listOfThings;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public T findById(long id) throws SQLException {
        try {
            if (id==0l){
                throw new SQLException("The id must be greater than 0L");
            }
            conn.setAutoCommit(false);
            String query="select * from "+getTableName()+" where id=?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1,id);
            ResultSet result =ps.executeQuery();
            result.next();
            newClass = mapResultToObject(result);
            return newClass;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try {
            conn.setAutoCommit(false);
            String query="delete from "+getTableName()+" where id=?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1,thingId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public void delete(T thingToDelete) {
        try {
            Long idOfObject=getThingId(thingToDelete);
            deleteById(idOfObject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Return the table name */
    public abstract String getTableName();

    /*Return the table fields in the order that we want to show it or use it it must be separated by
    * commas and lower case
    * */
    public abstract String getTableFields();
    /*Return the field values of the object that we want to add to the attributes in the new row of the table.
    they must be separated by comma in one string*/
    public abstract String getThingFields(T thing);

    public abstract Long getThingId(T thing);

    public abstract T mapResultToObject(ResultSet resultSet) throws SQLException;
}
