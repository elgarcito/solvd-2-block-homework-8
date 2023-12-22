package com.solvd.essay.persistence;

import com.solvd.essay.domain.Employee;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceGenerericDao<T> {

    public void create(final T thingToCreate) throws SQLException;
    public List<T> getAll() throws SQLException;


    public T findById(final long id) throws SQLException;

    public void deleteById (final Long thingId) throws SQLException;

    /*

    public void delete(final T thingToDelete);



    public void update(final T thingToUpdate);

    public void setThing(Class<T> thingToSet);


     */


}
