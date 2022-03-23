package com.example.pinball.commands;

import com.example.pinball.TheGame.Pinball;
import com.example.pinball.elements.PinballElement;

import java.util.ArrayList;
import java.util.List;

public class RampCommand implements Command{

    private Pinball pinball;
    private List<PinballElement> elements;


    public RampCommand(Pinball pinball) {
        this.pinball = pinball;
        this.elements = new ArrayList<>();
    }

    @Override
    public void execute(PinballElement element) {
        pinball.setScore(pinball.getScore() + 10000);
        for (PinballElement element1: this.elements) {
            element1.hit();
        }
    }

    public void add(PinballElement element) {
        elements.add(element);
    }

    public void remove(PinballElement element) {
        elements.remove(element);
    }

}
