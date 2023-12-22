package com.solvd.essay.domain;

import java.io.Serializable;

public class EssayModule {

    private Long id;
   private String moduleDescription;

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
}
