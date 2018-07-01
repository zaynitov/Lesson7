package com.example.myapplication;

public enum ItemTypes {
    FIRSTTYPE(0),
    SECONDTYPE(1),
    THIRDTYPE(2);
    int type;

    ItemTypes(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
