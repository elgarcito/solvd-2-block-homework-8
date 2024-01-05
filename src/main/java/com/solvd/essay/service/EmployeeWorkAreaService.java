package com.solvd.essay.service;

import com.solvd.essay.domain.EmployeeWorkArea;
import com.solvd.essay.persistence.EmployeeWorkAreaRepository;
import com.solvd.essay.persistence.impl.EmployeeWorkAreaRepositoryImpl;
//import com.solvd.essay.persistence.jdbcImpl.AbstracDao;
//import com.solvd.essay.persistence.jdbcImpl.EmployeeWorkAreaRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeWorkAreaService {
    //private final AbstracDao<EmployeeWorkArea> employeeWorkAreaRepositoryImpl = new EmployeeWorkAreaRepositoryImpl();
    private final EmployeeWorkAreaRepositoryImpl employeeWorkAreaRepositoryImpl = new EmployeeWorkAreaRepositoryImpl();

    public void create(EmployeeWorkArea employeeWorkArea){

            employeeWorkAreaRepositoryImpl.create(employeeWorkArea);

    }
    public List<EmployeeWorkArea> findAll() throws SQLException {
            return employeeWorkAreaRepositoryImpl.getAll();
    }

    public EmployeeWorkArea findOne(Long id) throws SQLException {
        EmployeeWorkArea result= employeeWorkAreaRepositoryImpl.findById(id);
        if (result==null){
            return new EmployeeWorkArea();
        }
        return result;
    }

    public void deleteOne(Long id) throws SQLException {
        employeeWorkAreaRepositoryImpl.deleteById(id);
    }



    public void updateEntity(EmployeeWorkArea employeeWorkArea,Long id){
        try {
            employeeWorkAreaRepositoryImpl.updateById(employeeWorkArea, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
