package com.example.pinball.elements;

import com.example.pinball.commands.Command;
import com.example.pinball.medirator.Mediator;
import com.example.pinball.visitor.Visitor;


public class Target implements PinballElement {
    private String name;
    private int hits = 0;
    private Command command;
    private Mediator mediator;
    private boolean isDown = false;


    public Target(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    @Override
    public void hit() {
        if (!isDown) {
            this.hits++;
            setDown(true);
            command.execute(this);
            mediator.hitTarget();
            System.out.println("THE " + name + " IS HIT!");
        } else {
            System.out.println("THE " + name + " IS DOWN!");
        }
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
