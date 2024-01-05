package com.solvd.essay.domain;

public class BatchInfo {
    private Long id;
    private String batchNumber;


    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BatchInfo{" +
                "id=" + id +
                ", batchNumber='" + batchNumber + '\'' +
                '}';
    }
}
