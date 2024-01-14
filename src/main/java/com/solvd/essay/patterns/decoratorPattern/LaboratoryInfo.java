package com.solvd.essay.patterns.decoratorPattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class LaboratoryInfo implements  LaboratoryExtraInfo{
    private static final Logger LOGGER = LogManager.getLogger(LaboratoryInfo.class);
    private int year;
    private int month;
    private int date;
    private int hour;

    @Override
    public void obtainExtraInfo() {
        LocalDateTime localDateTime= LocalDateTime.now();
        this.year=localDateTime.getYear();
        this.month=localDateTime.getMonthValue();
        this.date=localDateTime.getDayOfMonth();
        this.hour=localDateTime.getHour();
        LOGGER.info(String.format("The essay is done in the lab the year: "+
                "%s, month: %s ,day: %s ,hour: %s .%n",this.year,this.month,this.date,this.hour));
    }
}
