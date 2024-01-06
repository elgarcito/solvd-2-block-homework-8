package com.solvd.essay.service;

public enum Framework {
    //Change the name of the framework used to
    // jdbc
    // myBatis
    FRAMEWORK_USED_NAME("myBatis");
    private final String FRAMEWORK_USED;

    Framework(String FRAMEWORK_USED){
        this.FRAMEWORK_USED=FRAMEWORK_USED;
    }
    public String getFrameworkUsed(){
        return FRAMEWORK_USED_NAME.FRAMEWORK_USED;
    }

}
