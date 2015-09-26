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

    public static void main(String[] args) {
        IntAssignmentBlock assign = new IntAssignmentBlock("A");
        assign.setInternalBlock(new IntBlock(5));
        IfBlock ifBlock = new IfBlock();
        assign.setNextBlock(ifBlock);

        IntComparisonBlock lessThan = new IntComparisonBlock(IntComparisonBlock.GREATER_THAN);
        ifBlock.setInternalBlock(lessThan);
        lessThan.setInternalBlock(new AccessBlock("A"));
        lessThan.setSecondInternalBlock(new IntBlock(6));
        IntAssignmentBlock assign2 = new IntAssignmentBlock("B");
        assign2.setInternalBlock(new IntBlock(1));
        ifBlock.setSecondInternalBlock(assign2);

        Map<String, Integer> intMap = new HashMap<String, Integer>();

        BlockInterpreter blockInterpreter = new BlockInterpreter(assign, new HashSet<String>(), intMap, new HashMap<String, String>());
        blockInterpreter.interpret();

        for (String s : intMap.keySet()) {
            System.out.println(s + " : " + intMap.get(s));
        }
    }
}
