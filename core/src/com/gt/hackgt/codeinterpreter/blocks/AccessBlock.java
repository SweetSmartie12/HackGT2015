package com.gt.hackgt.codeinterpreter.blocks;

import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.IncompatibleTypesException;
import com.gt.hackgt.codeinterpreter.exceptions.MissingBlockException;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

import java.util.Map;
import java.util.Set;

/**
 * Used to access a variable's data.
 */
public class AccessBlock extends BasicBlock {
    private String name;

    public AccessBlock(GameObject gameObject, String name) {
        super(gameObject);
        this.name = name;
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
