package com.gt.hackgt.blocks;

import com.gt.hackgt.blocks.exceptions.IncompatibleTypesException;
import com.gt.hackgt.blocks.exceptions.MissingBlockException;
import com.gt.hackgt.blocks.exceptions.VariableDefinedException;

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

    public static void main(String[] args) {
        List<BasicBlock> list = new ArrayList<BasicBlock>();
        IntAssignmentBlock aBlock = new IntAssignmentBlock("A");
        aBlock.setInternalBlock(new IntBlock(5));
        IntAssignmentBlock bBlock = new IntAssignmentBlock("B");
        IntMathBlock mult = new IntMathBlock(IntMathBlock.MULTIPLY);
        mult.setInternalBlock(new IntBlock(3));
        IntMathBlock add = new IntMathBlock(IntMathBlock.PLUS);
        add.setInternalBlock(new IntBlock(1));
        add.setSecondInternalBlock(new IntBlock(2));
        mult.setSecondInternalBlock(add);
        bBlock.setInternalBlock(mult);
        list.add(aBlock);
        list.add(bBlock);
        Set<String> definedVars = new HashSet<String>();
        Map<String, Integer> intVars = new HashMap<String, Integer>();
        for (BasicBlock b : list) {
            try {
                b.execute(definedVars, intVars, null);
            } catch (VariableDefinedException e) {
                e.printStackTrace();
            } catch (IncompatibleTypesException e) {
                e.printStackTrace();
            } catch (MissingBlockException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Defined vars");
        for (String s : definedVars) {
            System.out.println(s);
        }

        System.out.println("\nValues");
        for (String s : intVars.keySet()) {
            System.out.println(s + " : " + intVars.get(s));
        }
    }
}
