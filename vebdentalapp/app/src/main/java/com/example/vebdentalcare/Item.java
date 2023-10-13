package com.example.vebdentalcare;

public class Item {
    private String name;
    private boolean value;

    public Item(String name, boolean value)
    {
        this.name=name;
        this.value=value;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }



}
