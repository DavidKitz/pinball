package com.example.pinball.visitor;

import com.example.pinball.elements.*;


public class Reset implements Visitor {


    @Override
    public void visit(Bumper bumper) {
        if (bumper.isLighted()) {
            bumper.setLighted(false);
        }
    }

    @Override
    public void visit(Flipper flipper) {
    }

    @Override
    public void visit(Hole hole) {

    }

    @Override
    public void visit(Kicker kicker) {
        if (kicker.isOn()) {
            kicker.setOn(false);
        }
    }

    @Override
    public void visit(Ramp ramp) {
        if (ramp.isOpen()) {
            ramp.setOpen(false);
        }
    }

    @Override
    public void visit(Spinner spinner) {
        if (spinner.getHits() > 0) {
            spinner.setHits(0);
        }
    }

    @Override
    public void visit(Target target) {
        if (target.isDown()) {
            target.setDown(false);
        }
    }
}
