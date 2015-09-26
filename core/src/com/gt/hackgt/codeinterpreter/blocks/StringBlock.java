package com.gt.hackgt.codeinterpreter.blocks;

import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

import java.util.Map;
import java.util.Set;

/**
 * A block that holds a string primitive.
 */
public class StringBlock extends BasicBlock {
    private String value;

    public StringBlock(GameObject gameObject, String val) {
        super(gameObject);
        value = val;
    }

    @Override
    public void draw() {

    }

    @Override
    public DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap, Map<String, String> stringVarMap)
            throws VariableDefinedException {
        return new DataObject(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
