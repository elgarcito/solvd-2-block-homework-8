package com.solvd.essay.patterns.decoratorPattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LabHumidityDecorator implements LaboratoryExtraInfo{
    private static final Logger LOGGER = LogManager.getLogger(LabHumidityDecorator.class);
    private LaboratoryExtraInfo laboratoryExtraInfo;
    private double labHumidity;

    public LabHumidityDecorator(LaboratoryExtraInfo laboratoryExtraInfo) {
        this.laboratoryExtraInfo = laboratoryExtraInfo;
    }

    @Override
    public void obtainExtraInfo() {
        this.laboratoryExtraInfo.obtainExtraInfo();
        this.labHumidity=10.0;
        LOGGER.info(String.format("Lab humidity is " +
                ": %.2f%% ",labHumidity));
    }
}
