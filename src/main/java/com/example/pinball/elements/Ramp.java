package com.example.pinball.elements;

import com.example.pinball.commands.Command;
import com.example.pinball.commands.RampCommand;
import com.example.pinball.visitor.Visitor;

public class Ramp implements PinballElement {
    private String name;
    private boolean isOpen = false;
    private int hits = 0;
    private Command command;

    public Ramp(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    @Override
    public void hit() {
        if (isOpen) {
            hits++;
            command.execute(this);
            System.out.println("THE " + name + " IS HIT!");
        } else {
            System.out.println("THE " + name + " IS CLOSE!");
        }
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

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
