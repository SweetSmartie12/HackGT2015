package com.gt.hackgt.gameobject;

/**
 * Created by Lauren on 9/25/2015.
 */

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gt.hackgt.codeinterpreter.BlockInterpreter;
import com.gt.hackgt.codeinterpreter.DataObject;
import com.gt.hackgt.codeinterpreter.blocks.BasicBlock;

import java.util.ArrayList;
import java.util.List;

public class GameObject extends Actor {

    private Texture texture;
    private float transparency;

    //TODO: add actual references here, this is just temp
    int gameWidth = 640;
    int gameHeight = 480;

    private String name;

    private int drawPriority;

    private ArrayList<String> tags;
    private ArrayList<Object> additionalFields;
    private List<BasicBlock> behaviors;

    public GameObject() {
        tags = new ArrayList<String>();
        additionalFields = new ArrayList<Object>();
        behaviors = new ArrayList<BasicBlock>();
    }

    public void addBehavior(BasicBlock block) {
        behaviors.add(block);
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setTransparency(float transparency) {
        this.transparency = transparency;
    }

    public int getPriority() {
        return drawPriority;
    }

    public void moveUp() {
        if (getY() > 0) {
            moveBy(0, -1);
        }
    }

    public void moveDown() {
        if (getY() < gameHeight) {
            moveBy(0, 1);
        }
    }

    public void moveLeft() {
        if (getX() > 0) {
            moveBy(-1, 0);
        }
    }

    public void moveRight() {
        if (getX() < gameWidth) {
            moveBy(1, 0);
        }
    }

    public void moveForward() {
        move(1);
    }

    public void moveBackward() {
        move(-1);
    }

    protected void move(int steps) {
        moveBy((float) (steps * Math.cos(getRotation())), (float) (steps * Math.sin(getRotation())));
    }

    @Override
    public void draw(Batch batch, float alpha) {
        super.draw(batch, alpha);
        if (texture != null) {
            batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        }
    }

    @Override
    public void act(float f) {
        super.act(f);
        for (BasicBlock block : behaviors) {
            BlockInterpreter interpreter = new BlockInterpreter(block);
            interpreter.interpret();
        }
    }

    public void executeSystemCall(String function, DataObject arg1, DataObject arg2) {
        // TODO(acalabrese): This doesn't do anything currently, you need to do something with this.
        // I am thinking that we have a pseudo runnable function for each system call, and use the function string
        // as a key into a map that gets us this system function. This would have the added benefit of forcing us to add
        // the system call only if it is useful for the user.
    }
}
