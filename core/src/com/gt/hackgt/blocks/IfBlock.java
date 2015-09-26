package com.gt.hackgt.blocks;

import com.gt.hackgt.blocks.exceptions.IncompatibleTypesException;
import com.gt.hackgt.blocks.exceptions.MissingBlockException;
import com.gt.hackgt.blocks.exceptions.VariableDefinedException;

import java.util.Map;
import java.util.Set;

/**
 * A block representing an if statement. Note here the internal block will be the conditional, and the second internal
 * block is the remaining code.
 */
public class IfBlock extends BasicBlock {

    public IfBlock() {

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
        if (conditional.getBooleanData()) {
            BlockInterpreter interpreter =
                    new BlockInterpreter(secondInternalBlock, varsDefined, intVarMap, stringVarMap);
            interpreter.interpret();
        }
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
