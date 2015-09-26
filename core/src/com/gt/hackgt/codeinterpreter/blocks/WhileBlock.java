package com.gt.hackgt.codeinterpreter.blocks;

import com.gt.hackgt.codeinterpreter.BlockInterpreter;
import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.IncompatibleTypesException;
import com.gt.hackgt.codeinterpreter.exceptions.MissingBlockException;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

import java.util.Map;
import java.util.Set;

/**
 * Block that deals with while loops. Note internalBlock refers to the conditional, and secondInternalBlock refers to
 * the loop.
 */
public class WhileBlock extends BasicBlock {

    public WhileBlock(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void draw() {

    }

    @Override
    public DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap, Map<String, String> stringVarMap)
            throws VariableDefinedException, IncompatibleTypesException, MissingBlockException {
        if (internalBlock == null || secondInternalBlock == null) {
            throw new MissingBlockException();
        }
        DataObject conditional = internalBlock.execute(varsDefined, intVarMap, stringVarMap);
        if (conditional.getType() != DataObject.BOOLEAN_TYPE) {
            throw new IncompatibleTypesException();
        }
        while (conditional.getBooleanData()) {
            BlockInterpreter interpreter =
                    new BlockInterpreter(secondInternalBlock, varsDefined, intVarMap, stringVarMap);
            interpreter.interpret();
            conditional = internalBlock.execute(varsDefined, intVarMap, stringVarMap);
        }
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
