package com.gt.hackgt.codeinterpreter.blocks;

import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.IncompatibleTypesException;
import com.gt.hackgt.codeinterpreter.exceptions.MissingBlockException;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

import java.util.Map;
import java.util.Set;

/**
 * Assigns an int variable with a certain value, creating it if need be.
 */
public class IntAssignmentBlock extends BasicBlock {
    private String name;

    public IntAssignmentBlock(GameObject gameObject, String name) {
        super(gameObject);
        this.name = name;
    }

    @Override
    public DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap, Map<String, String> stringVarMap)
            throws VariableDefinedException, IncompatibleTypesException, MissingBlockException {
        // TODO(acalabrese): Do we care about already created values.
        varsDefined.add(name);
        if (internalBlock == null) {
            throw new MissingBlockException();
        }
        DataObject res = internalBlock.execute(varsDefined, intVarMap, stringVarMap);
        if (res.getType() != DataObject.INT_TYPE) {
            throw new IncompatibleTypesException();
        }
        intVarMap.put(name, res.getIntData());
        return res;
    }

    @Override
    public String toString() {
        return name + " was assigned.";
    }
}
