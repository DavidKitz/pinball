package com.example.pinball.medirator;

import com.example.pinball.elements.*;

import java.util.List;

public class PinballMediator implements Mediator {

    private List<PinballElement> elements;
    private Ramp ramp;

    public PinballMediator(List<PinballElement> targets, Ramp ramp) {
        this.elements = targets;
        this.ramp = ramp;
    }

    @Override
    public void hitTarget() {
        boolean isOpen = true;
        for (PinballElement element : elements) {
            if (element instanceof Target) {
                Target target = (Target) element;
                isOpen &= target.isDown();
                ramp.setOpen(isOpen);
            }
        }
    }

}
