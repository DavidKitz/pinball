package com.example.pinball.visitor;

import com.example.pinball.elements.*;


public class Counter implements Visitor{

    private long point = 0;

    @Override
    public void visit(Bumper bumper) {
        if (bumper.getHits() >= 4)
            this.point += 10000;
        System.out.println("YOU GOT " + 10000 + " BONUS POINTS");
    }

    @Override
    public void visit(Flipper flipper) {
    }

    @Override
    public void visit(Hole hole) {
    }

    @Override
    public void visit(Kicker kicker) {
        if (kicker.getHits() >= 3) {
            this.point += 1000;
            System.out.println("YOU GOT " + 1000 + " BONUS POINTS");
        }
    }

    @Override
    public void visit(Ramp ramp) {
        if (ramp.isOpen()) {
            if (ramp.getHits() >= 2) {
                this.point += 5000;
                System.out.println("YOU GOT " + 5000 + " BONUS POINTS");
            }
        }

    }

    @Override
    public void visit(Spinner spinner) {
        if (spinner.getHits() > 2) {
            this.point += 3000;
            System.out.println("YOU GOT " + 3000 + " BONUS POINTS");
        }
    }

    @Override
    public void visit(Target target) {
        if (target.getHits() > 3) {
            this.point += 500;
            System.out.println("YOU GOT " + 500 + " BONUS POINTS");
        }
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }
}