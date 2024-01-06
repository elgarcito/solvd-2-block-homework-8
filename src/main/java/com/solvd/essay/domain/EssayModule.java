package com.solvd.essay.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;
@XmlRootElement(name="essayModule")
@XmlAccessorType(XmlAccessType.FIELD)
public class EssayModule {
    @XmlAttribute(name="id")
    private Long id;
   private String moduleDescription;
    private List<EssayModule> essayModuleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public List<EssayModule> getEssayModuleList() {
        return essayModuleList;
    }

    public void setEssayModuleList(List<EssayModule> essayModuleList) {
        this.essayModuleList = essayModuleList;
    }

    @Override
    public String toString() {
        return "EssayModule{" +
                "id=" + id +
                ", moduleDescription='" + moduleDescription + '\'' +
                '}';
    }
}
