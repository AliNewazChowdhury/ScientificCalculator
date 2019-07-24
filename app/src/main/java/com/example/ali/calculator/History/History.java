package com.example.ali.calculator.History;

/**
 * Created by ali on 2/5/2017.
 */

public class History {
    public int id;
    public String input;
    public String output;

    public History(int id, String input, String output){
        this.id = id;
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
