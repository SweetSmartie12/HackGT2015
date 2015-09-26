package com.gt.hackgt.codeinterpreter.blocks;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.exceptions.IncompatibleTypesException;
import com.gt.hackgt.codeinterpreter.exceptions.MissingBlockException;
import com.gt.hackgt.codeinterpreter.exceptions.VariableDefinedException;
import com.gt.hackgt.gameobject.GameObject;

import java.util.*;

/**
 * The basic building block of code.
 */
public abstract class BasicBlock extends Actor{
    protected int width;
    protected int height;
    protected int xPosition;
    protected int yPosition;
    protected BasicBlock internalBlock;
    protected BasicBlock secondInternalBlock;
    protected BasicBlock nextBlock;
    protected GameObject associatedObject;

    public BasicBlock(GameObject associatedObject){
        this.associatedObject = associatedObject;
    }

    public void draw(SpriteBatch batch, BitmapFont font) {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0f, 1f, 0f, 1f);
        shapeRenderer.rect(xPosition, yPosition, width, height);
        shapeRenderer.end();
    }

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

    public float getWidth() {
        return width;
    }

    public float getHeight() {
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

    public int getCenterTopX() {
        return xPosition + (width / 2);
    }

    public int getCenterTopY() {
        return yPosition + height;
    }

    public int getCenterBottomX() {
        return xPosition + (width / 2);
    }

    public int getCenterBottomY() {
        return yPosition;
    }

    public abstract String toString();
}
