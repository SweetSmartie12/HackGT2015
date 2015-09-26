package com.gt.hackgt.codeinterpreter.blocks;

import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.IncompatibleTypesException;
import com.gt.hackgt.codeinterpreter.exceptions.MissingBlockException;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

import java.util.*;

/**
 * The basic building block of code.
 */
public abstract class BasicBlock {
    protected int width;
    protected int height;
    protected int xPosition;
    protected int yPosition;
    protected BasicBlock internalBlock;
    protected BasicBlock secondInternalBlock;
    protected BasicBlock nextBlock;
    protected GameObject associatedObject;

    public BasicBlock(GameObject associatedObject) {
        this.associatedObject = associatedObject;
    }

    public abstract void draw();

    public abstract DataObject execute(Set<String> varsDefined, Map<String, Integer> intVarMap,
                                 Map<String, String> stringVarMap)
            throws VariableDefinedException, IncompatibleTypesException, MissingBlockException;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setXPosition(int x) {
        this.xPosition = x;
    }

    public void setYPosition(int y) {
        this.yPosition = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setInternalBlock(BasicBlock internal) {
        this.internalBlock = internal;
    }

    public BasicBlock getInternalBlock() {
        return internalBlock;
    }

    public void setSecondInternalBlock(BasicBlock internal) {
        this.secondInternalBlock = internal;
    }

    public BasicBlock getSecondInternalBlock() {
        return secondInternalBlock;
    }

    public void setNextBlock(BasicBlock block) {
        this.nextBlock = block;
    }

    public BasicBlock getNextBlock() {
        return nextBlock;
    }

    public abstract String toString();
}
