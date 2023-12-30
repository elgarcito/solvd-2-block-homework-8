package com.solvd.essay.persistence;

import com.solvd.essay.domain.Employee;

import java.lang.reflect.Parameter;
import java.util.List;

public interface EmployeeRepository {

    public Employee findById(final long id);

    public List<Employee> findAll();

    public void delete(final Employee employee);
    public void deleteById (final Long id);

    public void create(final Employee employee);
    public void update(final Employee employee);


}
