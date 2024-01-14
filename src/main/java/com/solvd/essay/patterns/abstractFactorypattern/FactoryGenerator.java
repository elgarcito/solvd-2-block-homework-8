package com.solvd.essay.patterns.abstractFactorypattern;

import com.solvd.essay.patterns.abstractFactorypattern.AbstractFactory;
import com.solvd.essay.patterns.factoryPattern.ImplementationFactory;

public class FactoryGenerator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equals("implementation")){
            return null;
        }else {
            return null;
        }
    }
}
