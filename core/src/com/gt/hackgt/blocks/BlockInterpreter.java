package com.gt.hackgt.blocks;

import com.gt.hackgt.blocks.exceptions.IncompatibleTypesException;
import com.gt.hackgt.blocks.exceptions.MissingBlockException;
import com.gt.hackgt.blocks.exceptions.VariableDefinedException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Interprets a group of blocks starting with the first and following in a linked list fashion.
 */
public class BlockInterpreter {
    private BasicBlock startBlock;
    private Set<String> definedVars = new HashSet<String>();
    private Map<String, Integer> intVarMap = new HashMap<String, Integer>();
    private Map<String, String> stringVarMap = new HashMap<String, String>();


    public BlockInterpreter(BasicBlock startBlock) {
        this.startBlock = startBlock;
        definedVars = new HashSet<String>();
        intVarMap = new HashMap<String, Integer>();
        stringVarMap = new HashMap<String, String>();
    }

    public BlockInterpreter(
            BasicBlock startBlock, Set<String> vars, Map<String, Integer> ints, Map<String, String> strings) {
        this.startBlock = startBlock;
        definedVars = vars;
        intVarMap = ints;
        stringVarMap = strings;
    }

    public void interpret() {
        BasicBlock currentBlock = startBlock;

        boolean exceptionCaught = false;
        while (!exceptionCaught && currentBlock != null) {
            try {
                currentBlock.execute(definedVars, intVarMap, stringVarMap);
            } catch (VariableDefinedException e) {
                exceptionCaught = true;
            } catch (IncompatibleTypesException e) {
                exceptionCaught = true;
            } catch (MissingBlockException e) {
                exceptionCaught = true;
            }
            currentBlock = currentBlock.getNextBlock();
        }
    }
}
