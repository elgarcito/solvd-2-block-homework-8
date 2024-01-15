package com.solvd.essay.patterns.abstractFactorypattern;

import com.solvd.essay.patterns.abstractFactorypattern.AbstractFactory;
import com.solvd.essay.patterns.factoryPattern.ImplementationFactory;

public class FactoryGenerator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equals("implementation")){
            return new ImplementationFactory();
        }else {
            //Another factory for the future
            return null;
        }
    }
}
