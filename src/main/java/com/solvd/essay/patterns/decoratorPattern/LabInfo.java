package com.solvd.essay.patterns.decoratorPattern;

public class LabInfo {
    public static void obtainExtraLabInfo(boolean temperature,boolean humidity){
        LaboratoryExtraInfo laboratoryExtraInfo= new LaboratoryInfo();
        if (temperature){
            laboratoryExtraInfo=new LabTemperatureDecorator(laboratoryExtraInfo);
        }if (humidity){
            laboratoryExtraInfo=new LabHumidityDecorator(laboratoryExtraInfo);
        }
        laboratoryExtraInfo.obtainExtraInfo();
    }
}
