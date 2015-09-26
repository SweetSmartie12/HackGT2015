package com.gt.hackgt.blocks;

import com.gt.hackgt.blocks.exceptions.IncompatibleTypesException;
import com.gt.hackgt.blocks.exceptions.MissingBlockException;
import com.gt.hackgt.blocks.exceptions.VariableDefinedException;

import java.util.Map;
import java.util.Set;

/**
 * Assigns a string to a variable, creating it if need be.
 */
public class StringAssignmentBlock extends BasicBlock {

    private String name;

    public StringAssignmentBlock(String name) {
        this.name = name;
    }

    @Override
    public void draw() {

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
        if (res.getType() != DataObject.STRING_TYPE) {
            throw new IncompatibleTypesException();
        }
        stringVarMap.put(name, res.getStringData());
        return res;
    }

    @Override
    public String toString() {
        return name + " was assigned.";
    }
}
