package com.gt.hackgt.codeinterpreter;

/**
 * Represents the data that is passed between codeinterpreter.
 */
public class DataObject {
    public static final int NULL_TYPE = 0;
    public static final int INT_TYPE = 1;
    public static final int BOOLEAN_TYPE = 2;
    public static final int STRING_TYPE = 3;

    private String stringData;
    private int intData;
    private boolean booleanData;
    private int type;

    public DataObject() {
        type = NULL_TYPE;
    }

    public DataObject(String s) {
        stringData = s;
        type = STRING_TYPE;
    }

    public DataObject(int i) {
        intData = i;
        type = INT_TYPE;
    }

    public DataObject(boolean b) {
        booleanData = b;
        type = BOOLEAN_TYPE;
    }

    public String getStringData() {
        return stringData;
    }

    public int getIntData() {
        return intData;
    }

    public boolean getBooleanData() {
        return booleanData;
    }

    public int getType() {
        return type;
    }
}
