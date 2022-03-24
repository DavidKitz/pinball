package com.example.pinball.commands;

import com.example.pinball.TheGame.Pinball;
import com.example.pinball.elements.Hole;
import com.example.pinball.elements.PinballElement;
import com.example.pinball.status.NoCredit;
import com.example.pinball.visitor.Counter;
import com.example.pinball.visitor.Reset;

public class Commander implements Command {
    private Pinball pinball;
    private int lvl = 1;
    private Reset reset;
    private Counter counter;

    public Commander(Pinball pinball, Reset reset, Counter counter) {
        this.pinball = pinball;
        this.reset = reset;
        this.counter = counter;
    }

    @Override
    public void execute(PinballElement element) {
        if (element instanceof Hole) {
            holeOnAction();
        } else {
            element.accept(counter);
            if (counter.getPoint() >= 500L * lvl) {
                setLvl(lvl + 1);
                System.out.println("YOUR LEVEL IS " + this.lvl);
            }
            pinball.setScore(pinball.getScore() + (lvl * 1000L));
            System.out.println(pinball.getScore());
        }
    }

    public void holeOnAction() {
        for (PinballElement element1 : pinball.getElements()) {
            element1.accept(reset);
        }
        System.out.println("YOUR SCORE IS:" + pinball.getScore() + " AND " + counter.getPoint() + " BONUS.");
        pinball.setScore(pinball.getScore() + counter.getPoint());
        pinball.setBalls(pinball.getBalls() - 1);
        if (pinball.getBalls() == 1) {
            System.out.println(pinball.getFactory().createBall2());
        } else if (pinball.getBalls() == 0) {
            System.out.println(pinball.getFactory().createBall3());
        } else if (pinball.getBalls() < 0) {
            if (pinball.getScore() >= 40000 && lvl >= 2) {
                System.out.println("YOU WON, CONGRATS!!");
            } else if (pinball.getScore() < 40000) {
                System.out.println(pinball.getFactory().createGameOver());
            }
            pinball.setScore(0);
            pinball.setStatus(new NoCredit());
        }
        counter.setPoint(0);
        this.lvl = 1;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}
