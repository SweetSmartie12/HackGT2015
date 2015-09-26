package com.gt.hackgt.codeinterpreter.blocks;

import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.IncompatibleTypesException;
import com.gt.hackgt.codeinterpreter.exceptions.MissingBlockException;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

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

    public IntComparisonBlock(GameObject gameObject, int operator) {
        super(gameObject);
        this.operator = operator;
    }

    @Override
    public DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap, Map<String, String> stringVarMap)
            throws VariableDefinedException, IncompatibleTypesException, MissingBlockException {
        if (internalBlock == null || secondInternalBlock == null) {
            throw new MissingBlockException();
        }
        DataObject d1 = internalBlock.execute(varsDefined, intVarMap, stringVarMap);
        DataObject d2 = secondInternalBlock.execute(varsDefined, intVarMap, stringVarMap);
        if (d1.getType() != DataObject.INT_TYPE || d2.getType() != DataObject.INT_TYPE) {
            throw new IncompatibleTypesException();
        }
        return evaluate(d1.getIntData(), d2.getIntData());
    }

    private DataObject evaluate(int a, int b) {
        boolean res = false;
        switch (operator) {
            case LESS_THAN:
                res = a < b;
                break;

            case LESS_THAN_EQUAL:
                res = a <= b;
                break;

            case GREATER_THAN:
                res = a > b;
                break;

            case GREATER_THAN_EQUAL:
                res = a >= b;
                break;

            case EQUAL:
                res = a == b;
                break;

            case NOT_EQUAL:
                res = a != b;
                break;
        }
        return new DataObject(res);
    }

    @Override
    public String toString() {
        return null;
    }
}
