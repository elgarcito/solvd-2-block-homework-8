package com.solvd.essay.persistence;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceGenericDao<T> {

    public void create(final T thingToCreate) throws SQLException;
    public List<T> getAll() throws SQLException;


    public T findById(final long id) throws SQLException;

    public void deleteById (final Long thingId) throws SQLException;


    public void updateById(final T thingToUpdate, Long id) throws SQLException;

    /*







    public void setThing(Class<T> thingToSet);


     */


}
