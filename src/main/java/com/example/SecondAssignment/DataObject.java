package com.example.SecondAssignment;

public class DataObject {

    private Integer addition;
    private Integer subtraction;

    public DataObject(Integer addition, Integer subtraction) {
        this.addition = addition;
        this.subtraction = subtraction;
    }

    public Integer getaddition() {
        return addition;
    }

    public void setaddition(Integer addition) {
        this.addition = addition;
    }

    public Integer getsubtraction() {
        return subtraction;
    }

    public void setsubtraction(Integer subtraction) {
        this.subtraction = subtraction;
    }
}
