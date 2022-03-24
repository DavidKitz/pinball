package com.example.pinball.elements;

import com.example.pinball.visitor.Visitor;

import java.util.Random;

public class Flipper implements PinballElement{
    private String name;

    public Flipper(String name) {
        this.name = name;
    }


    @Override
    public void hit() {
        System.out.println("THE " + name + " IS HIT!");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
