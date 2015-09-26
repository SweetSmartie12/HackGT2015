package com.gt.hackgt.blocks;

import com.gt.hackgt.blocks.exceptions.IncompatibleTypesException;
import com.gt.hackgt.blocks.exceptions.MissingBlockException;
import com.gt.hackgt.blocks.exceptions.VariableDefinedException;

import java.util.Map;
import java.util.Set;

/**
 * Compares two ints.
 */
public class IntComparisonBlock extends BasicBlock {
    public static final int LESS_THAN = 0;
    public static final int LESS_THAN_EQUAL = 1;
    public static final int GREATER_THAN = 2;
    public static final int GREATER_THAN_EQUAL = 3;
    public static final int EQUAL = 4;
    public static final int NOT_EQUAL = 5;

    private int operator;

    public IntComparisonBlock(int operator) {
        this.operator = operator;
    }

    @Override
    public void draw() {

    }

    @Override
    public DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap, Map<String, String> stringVarMap)
            throws VariableDefinedException, IncompatibleTypesException, MissingBlockException {

        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
