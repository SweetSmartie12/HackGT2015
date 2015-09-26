package com.gt.hackgt.codeinterpreter.blocks;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gt.hackgt.codeinterpreter.BlockInterpreter;
import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.IncompatibleTypesException;
import com.gt.hackgt.codeinterpreter.exceptions.MissingBlockException;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

import java.util.Map;
import java.util.Set;

/**
 * A block representing an if statement. Note here the internal block will be the conditional, and the second internal
 * block is the remaining code.
 */
public class IfBlock extends BasicBlock {

    public IfBlock(GameObject gameObject) {
        super(gameObject);
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
    public void draw(SpriteBatch batch, BitmapFont font) {
        super.draw(batch, font);
    }

    @Override
    public String toString() {
        return null;
    }
}
