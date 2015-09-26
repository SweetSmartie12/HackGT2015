package com.gt.hackgt.blocks;

import com.gt.hackgt.blocks.exceptions.IncompatibleTypesException;
import com.gt.hackgt.blocks.exceptions.MissingBlockException;
import com.gt.hackgt.blocks.exceptions.VariableDefinedException;

import java.util.Map;
import java.util.Set;

/**
 * Used to access a variable's data.
 */
public class AccessBlock extends BasicBlock {
    private String name;

    public AccessBlock(String name) {
        this.name = name;
    }

    @Override
    public void draw() {

    }

    @Override
    public DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap, Map<String, String> stringVarMap)
            throws VariableDefinedException, IncompatibleTypesException, MissingBlockException {
        if (!varsDefined.contains(name)) {
            throw new VariableDefinedException(name);
        }
        Integer intVal = intVarMap.get(name);
        String strVal = stringVarMap.get(name);
        return (intVal != null ? new DataObject(intVal) : new DataObject(strVal));
    }

    @Override
    public String toString() {
        return null;
    }
}
