package com.solvd.essay.patterns.abstractFactorypattern;

import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.patterns.factoryPattern.ImplementationFactory;
import com.solvd.essay.persistence.InterfaceGenericDao;

public abstract class AbstractFactory {
    public abstract ImplementationFactory getImplementation();
}
