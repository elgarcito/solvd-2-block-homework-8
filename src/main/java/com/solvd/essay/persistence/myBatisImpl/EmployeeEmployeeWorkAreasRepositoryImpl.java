package com.solvd.essay.persistence.myBatisImpl;

import com.solvd.essay.domain.EmployeeEmployeeWorkAreas;
import com.solvd.essay.persistence.EmployeeEmployeeWorkAreasRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class EmployeeEmployeeWorkAreasRepositoryImpl implements EmployeeEmployeeWorkAreasRepository {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeEmployeeWorkAreasRepositoryImpl.class);
    @Override
    public void create(EmployeeEmployeeWorkAreas thingToCreate)  {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
           EmployeeEmployeeWorkAreasRepository employeeEmployeeWorkAreasRepository= sqlSession.getMapper(EmployeeEmployeeWorkAreasRepository.class);
            employeeEmployeeWorkAreasRepository.create(thingToCreate);
        }catch (SQLException | PersistenceException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<EmployeeEmployeeWorkAreas> getAll() throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeEmployeeWorkAreasRepository employeeEmployeeWorkAreasRepository= sqlSession.getMapper(EmployeeEmployeeWorkAreasRepository.class);
            return employeeEmployeeWorkAreasRepository.getAll();
        }
    }

    @Override
    public EmployeeEmployeeWorkAreas findById(long id) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeEmployeeWorkAreasRepository employeeEmployeeWorkAreasRepository= sqlSession.getMapper(EmployeeEmployeeWorkAreasRepository.class);
            return employeeEmployeeWorkAreasRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeEmployeeWorkAreasRepository employeeEmployeeWorkAreasRepository= sqlSession.getMapper(EmployeeEmployeeWorkAreasRepository.class);
            employeeEmployeeWorkAreasRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(EmployeeEmployeeWorkAreas thingToUpdate, Long entityId) throws SQLException {
        try(SqlSession sqlSession= MyPersistenceConfig.getSessionFactory().openSession(true)){
            EmployeeEmployeeWorkAreasRepository employeeEmployeeWorkAreasRepository= sqlSession.getMapper(EmployeeEmployeeWorkAreasRepository.class);
            employeeEmployeeWorkAreasRepository.updateById(thingToUpdate,entityId);
        }
    }
}