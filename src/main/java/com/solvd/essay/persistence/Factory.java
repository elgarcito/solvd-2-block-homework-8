package com.solvd.essay.persistence;

import com.solvd.essay.domain.*;
import com.solvd.essay.service.Framework;

    public class Factory {
        public static InterfaceGenericDao<BatchInfo> getBatchInfoRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.BatchInfoRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.BatchInfoRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<Employee> getEmployeeRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.EmployeeRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.EmployeeRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<EmployeeEmployeeWorkAreas> getEmployeeEmployeeWorkAreasRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.EmployeeEmployeeWorkAreasRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.EmployeeEmployeeWorkAreasRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<EmployeeLaboratoryTools> getEmployeeLaboratoryToolsRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.EmployeeLaboratoryToolsRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.EmployeeLaboratoryToolsRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<EmployeeWorkArea> getEmployeeWorkAreaRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.EmployeeWorkAreaRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.EmployeeWorkAreaRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<EnergyEfficiencyEssay> getEnergyEfficiencyEssayRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.EnergyEfficiencyEssayRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.EnergyEfficiencyEssayRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<EquipmentForTestModel> getEquipmentForTestModelRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.EquipmentForTestModelRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.EquipmentForTestModelRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<EssayModule> getEssayModuleRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.EssayModuleRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.EssayModuleRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<GasConsumptionEssay> getGasConsumptionEssayRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.GasConsumptionEssayRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.GasConsumptionEssayRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<LaboratoryTool> getLaboratoryToolRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.LaboratoryToolRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.LaboratoryToolRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<LabTestReport> getLabTestReportRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.LabTestReportRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.LabTestReportRepositoryImpl();
                default:
                    return null;
            }
        }

        public static InterfaceGenericDao<TemperatureEssay> getTemperatureEssayRepositoryImpl(String value) {
            switch (value) {
                case "myBatis":
                    return new com.solvd.essay.persistence.myBatisImpl.TemperatureEssayRepositoryImpl();
                case "jdbc":
                    return new com.solvd.essay.persistence.jdbcImpl.TemperatureEssayRepositoryImpl();
                default:
                    return null;
            }
        }
    }


