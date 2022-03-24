package com.example.pinball.elements;

import com.example.pinball.commands.Command;
import com.example.pinball.visitor.Visitor;

public class Hole implements PinballElement {
    private String name;
    private Command command;

    public Hole(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    @Override
    public void hit() {
        System.out.println("YOU LOST A BALL!");
        command.execute(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
