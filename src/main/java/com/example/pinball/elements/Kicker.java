package com.example.pinball.elements;

import com.example.pinball.commands.Command;
import com.example.pinball.visitor.Visitor;

public class Kicker implements PinballElement{
    private String name;
    private int hits = 0;
    private Command command;
    private boolean isOn = false;


    public Kicker(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    @Override
    public void hit() {
        System.out.println("THE " + name + " IS HIT!");
        command.execute(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setCommand(Command command) {
        this.command = command;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
