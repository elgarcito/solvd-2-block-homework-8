package com.solvd.essay.patterns.decoratorPattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LabTemperatureDecorator implements LaboratoryExtraInfo{
    private static final Logger LOGGER = LogManager.getLogger(LabTemperatureDecorator.class);

    private final LaboratoryExtraInfo laboratoryExtraInfo;
    private Double labTemperature;

    public LabTemperatureDecorator(LaboratoryExtraInfo laboratoryExtraInfo) {
        this.laboratoryExtraInfo = laboratoryExtraInfo;
    }

    @Override
    public void obtainExtraInfo() {
        laboratoryExtraInfo.obtainExtraInfo();
        this.labTemperature=24.0;
        LOGGER.info(String.format("Lab temperature is " +
                ": %s °C ",labTemperature));
    }
}
