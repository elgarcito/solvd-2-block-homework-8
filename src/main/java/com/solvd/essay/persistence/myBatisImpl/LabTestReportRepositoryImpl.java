package com.solvd.essay.persistence.myBatisImpl;

import com.solvd.essay.domain.LabTestReport;
import com.solvd.essay.persistence.LabTestReportRepository;
import com.solvd.essay.persistence.MyPersistenceConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class LabTestReportRepositoryImpl implements LabTestReportRepository {
    private static final Logger LOGGER = LogManager.getLogger(LabTestReportRepositoryImpl.class);

    @Override
    public void create(LabTestReport thingToCreate) {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            LabTestReportRepository labTestReportRepository = sqlSession.getMapper(LabTestReportRepository.class);
            labTestReportRepository.create(thingToCreate);
        } catch (SQLException |PersistenceException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<LabTestReport> getAll() throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            LabTestReportRepository labTestReportRepository = sqlSession.getMapper(LabTestReportRepository.class);
            return labTestReportRepository.getAll();
        }
    }

    @Override
    public LabTestReport findById(long id) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            LabTestReportRepository labTestReportRepository = sqlSession.getMapper(LabTestReportRepository.class);
            return labTestReportRepository.findById(id);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            LabTestReportRepository labTestReportRepository = sqlSession.getMapper(LabTestReportRepository.class);
            labTestReportRepository.deleteById(thingId);
        }
    }

    @Override
    public void updateById(LabTestReport thingToUpdate, Long entityId) throws SQLException {
        try (SqlSession sqlSession = MyPersistenceConfig.getSessionFactory().openSession(true)) {
            LabTestReportRepository labTestReportRepository = sqlSession.getMapper(LabTestReportRepository.class);
            labTestReportRepository.updateById(thingToUpdate,entityId);
        }
    }
}
