package com.gt.hackgt.blocks;

import com.gt.hackgt.blocks.exceptions.MissingBlockException;
import com.gt.hackgt.blocks.exceptions.VariableDefinedException;

import java.util.Map;
import java.util.Set;

/**
 * A block that holds an int primitive.
 */
public class IntBlock extends BasicBlock {
    private int value;

    public IntBlock(int val) {
        value = val;
    }

    @Override
    public void draw() {

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
