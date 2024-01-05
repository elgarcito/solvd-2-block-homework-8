package com.solvd.essay.domain;

import java.util.List;

public class BatchInfo {
    private Long id;
    private String batchNumber;

    private List<BatchInfo> myBatchInfoList;


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

    public List<BatchInfo> getMyBatchInfoList() {
        return myBatchInfoList;
    }

    public void setMyBatchInfoList(List<BatchInfo> myBatchInfoList) {
        this.myBatchInfoList = myBatchInfoList;
    }

    @Override
    public String toString() {
        return "BatchInfo{" +
                "id=" + id +
                ", batchNumber='" + batchNumber + '\'' +
                ", myBatchInfoList=" + myBatchInfoList +
                '}';
    }
}
