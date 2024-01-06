package com.solvd.essay.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name="batchInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class BatchInfo {

    @XmlAttribute(name="id")

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
                '}';
    }
}
