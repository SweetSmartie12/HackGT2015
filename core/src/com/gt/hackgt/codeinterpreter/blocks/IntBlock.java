package com.gt.hackgt.codeinterpreter.blocks;

import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.MissingBlockException;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

import java.util.Map;
import java.util.Set;

/**
 * A block that holds an int primitive.
 */
public class IntBlock extends BasicBlock {
    private int value;

    public IntBlock(GameObject gameObject, int val) {
        super(gameObject);
        value = val;
    }

    @Override
    public DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap, Map<String, String> stringVarMap)
            throws VariableDefinedException, MissingBlockException {
        return new DataObject(value);
    }

    @Override
    public String toString() {
        return value + "";
    }
}
