package com.solvd.essay.patterns.observerPattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MachineSupplier implements Observer {
    private String supplierName;
    private String supplierType;
    private static final Logger LOGGER = LogManager.getLogger(MachineSupplier.class);
    private Subject labOwner;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    @Override
    public void update() {
        String ownerMessage= labOwner.getUpdate(this);
        if (ownerMessage==null){
            LOGGER.info("No new message from the lab Owner");
        }else {
            LOGGER.info(ownerMessage);
        }


    }

    @Override
    public void setSubject(Subject subject) {
        this.labOwner=subject;
    }
}
