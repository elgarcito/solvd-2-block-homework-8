package com.solvd.essay.service;

import com.solvd.essay.domain.EmployeeEmployeeWorkAreas;
import com.solvd.essay.patterns.factoryPattern.ImplementationFactory;
import com.solvd.essay.persistence.InterfaceGenericDao;
//import com.solvd.essay.persistence.jdbcImpl.AbstractDao;
//import com.solvd.essay.persistence.jdbcImpl.EmployeeEmployeeWorkAreasRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeEmployeeWorkAreasService {
    final InterfaceGenericDao<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasRepositoryImpl = ImplementationFactory.getEmployeeEmployeeWorkAreasRepositoryImpl(Framework.FRAMEWORK_USED_NAME.getFrameworkUsed());

    public void create(EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas) throws SQLException {
        employeeEmployeeWorkAreasRepositoryImpl.create(employeeEmployeeWorkAreas);
    }
    public List<EmployeeEmployeeWorkAreas> findAll() throws SQLException {
        List<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasList= employeeEmployeeWorkAreasRepositoryImpl.getAll();
        return employeeEmployeeWorkAreasList;
    }

    public EmployeeEmployeeWorkAreas findOne(Long id) throws SQLException {
        EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas= employeeEmployeeWorkAreasRepositoryImpl.findById(id);
        if (employeeEmployeeWorkAreas==null){
            return new EmployeeEmployeeWorkAreas();
        }
        /*
        AbstractDao<Employee> newEmployeeImplementation= new EmployeeRepositoryImpl();
        EmployeeService newEmployeeService= new EmployeeService(newEmployeeImplementation);

        AbstractDao<EmployeeWorkArea> newEmployeeWorkAreaImpl= new EmployeeWorkAreaRepositoryImpl();
        EmployeeWorkAreaService newEmployeeWorkAreaService= new EmployeeWorkAreaService(newEmployeeWorkAreaImpl);

        employeeEmployeeWorkAreas.setEmployee(newEmployeeService.findOne(employeeEmployeeWorkAreas.getEmployeeId()));
        employeeEmployeeWorkAreas.setEmployeeWorkArea(newEmployeeWorkAreaService.findOne(employeeEmployeeWorkAreas.getEmployeeworkAreaId()));

         */
        return employeeEmployeeWorkAreas;
    }

    public void deleteOne(Long id) throws SQLException {
        employeeEmployeeWorkAreasRepositoryImpl.deleteById(id);
    }


    public void updateEntity(EmployeeEmployeeWorkAreas employeeEmployeeWorkAreas, Long id){
        try {
            employeeEmployeeWorkAreasRepositoryImpl.updateById(employeeEmployeeWorkAreas, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
