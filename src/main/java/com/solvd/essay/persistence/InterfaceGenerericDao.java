package com.solvd.essay.persistence;

import com.solvd.essay.domain.Employee;

import java.util.List;

public interface InterfaceGenerericDao<T> {

    public T findById(final long id);

    public void delete(final T thingToDelete);
    public void deleteById (final Long thingId);

    public void create(final T thingToCreate);
    public void update(final T thingToUpdate);

    public void setThing(Class<T> thingToSet);
    public List<T> findAll();

}
