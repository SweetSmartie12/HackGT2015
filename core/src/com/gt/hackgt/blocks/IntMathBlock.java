package com.gt.hackgt.blocks;

import com.gt.hackgt.blocks.exceptions.IncompatibleTypesException;
import com.gt.hackgt.blocks.exceptions.MissingBlockException;
import com.gt.hackgt.blocks.exceptions.VariableDefinedException;

import java.util.Map;
import java.util.Set;

/**
 * Used to do math on integers.
 */
public class IntMathBlock extends BasicBlock {
    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int MULTIPLY = 2;
    public static final int DIVIDE = 3;

    private int operator;

    public IntMathBlock(int operator) {
        this.operator = operator;
    }

    @Override
    public void draw() {

    }

    @Override
    public DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap, Map<String, String> stringVarMap)
            throws VariableDefinedException, IncompatibleTypesException, MissingBlockException {
        if (secondInternalBlock == null || internalBlock == null) {
            throw new MissingBlockException();
        }
        DataObject d1 = internalBlock.execute(varsDefined, intVarMap, stringVarMap);
        DataObject d2 = secondInternalBlock.execute(varsDefined, intVarMap, stringVarMap);
        if (d1.getType() != DataObject.INT_TYPE || d2.getType() != DataObject.INT_TYPE) {
            throw new IncompatibleTypesException();
        }

        return evaluate(d1, d2);
    }

    private DataObject evaluate(DataObject d1, DataObject d2) {
        int res = 0;
        int a = d1.getIntData();
        int b = d2.getIntData();
        switch (operator) {
            case PLUS:
                res = a + b;
                break;

            case MINUS:
                res = a - b;
                break;

            case MULTIPLY:
                res = a * b;
                break;

            case DIVIDE:
                res = a / b;
                break;
        }
        return new DataObject(res);
    }

    @Override
    public String toString() {
        return null;
    }
}
