package com.uam.proyectouam.calculators;

import org.openxava.calculators.ICalculator;

import java.util.Date;

public class CurrentDateCalculator implements ICalculator {

    @Override
    public Object calculate() throws Exception {
        return new Date();
    }
}

