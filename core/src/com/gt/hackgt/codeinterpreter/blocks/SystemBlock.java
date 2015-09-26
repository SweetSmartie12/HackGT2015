package com.gt.hackgt.codeinterpreter.blocks;

import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.IncompatibleTypesException;
import com.gt.hackgt.codeinterpreter.exceptions.MissingBlockException;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

import java.util.Map;
import java.util.Set;

/**
 * Used to call various system methods on a game object.
 */
public class SystemBlock extends BasicBlock {
    private String function;

    public SystemBlock(GameObject associatedObject, String function) {
        super(associatedObject);
        this.function = function;
    }

    @Override
    public void draw() {

    }

    @Override
    public DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap, Map<String, String> stringVarMap)
            throws VariableDefinedException, IncompatibleTypesException, MissingBlockException {
        DataObject d1 = new DataObject();
        if (internalBlock != null) {
            d1 = internalBlock.execute(varsDefined, intVarMap, stringVarMap);
        }
        DataObject d2 = new DataObject();
        if (secondInternalBlock != null) {
            d2 = secondInternalBlock.execute(varsDefined, intVarMap, stringVarMap);
        }

        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
