package com.solvd.essay;

import com.solvd.essay.domain.EssayModule;
import jakarta.xml.bind.annotation.*;

import java.util.List;
@XmlRootElement(name="essayModuleList")
@XmlAccessorType(XmlAccessType.FIELD)
public class EssayModuleList {
    @XmlAttribute(name="id")
    private Long id;
    @XmlElementWrapper(name="essayModules")
    @XmlElement(name="essayModule")
   private List<EssayModule> essayModuleList;

    public List<EssayModule> getEssayModuleList() {
        return essayModuleList;
    }

    public void setEssayModuleList(List<EssayModule> essayModuleList) {
        this.essayModuleList = essayModuleList;
    }
}
