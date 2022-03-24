package com.example.pinball.elements;

import com.example.pinball.commands.Command;
import com.example.pinball.medirator.Mediator;
import com.example.pinball.visitor.Visitor;

public class Bumper implements PinballElement {
    private String name;
    private boolean isLighted = false;
    private Command command;
    private int hits = 0;

    public Bumper(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    @Override
    public void hit() {
        this.hits++;
        setLighted(true);
        command.execute(this);
        System.out.println("THE " + name + " IS HIT!");
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

    public boolean isLighted() {
        return isLighted;
    }

    public void setLighted(boolean lighted) {
        isLighted = lighted;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
