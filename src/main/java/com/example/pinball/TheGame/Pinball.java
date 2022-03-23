package com.example.pinball.TheGame;

import com.example.pinball.elements.PinballElement;
import com.example.pinball.factories.MainFactory;
import com.example.pinball.status.NoCredit;
import com.example.pinball.status.Status;

import java.util.List;

public class Pinball {

    private static Pinball pinball = new Pinball(new NoCredit());
    private Status status;
    private int credit = 0;
    private int balls = 0;
    private MainFactory factory;
    private List<PinballElement> elements;
    private long score = 0;

    public Pinball(Status status) {
        this.status = status;
    }


    public static Pinball getPinball() {
        return pinball;
    }

    public static void setPinball(Pinball pinball) {
        Pinball.pinball = pinball;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public MainFactory getFactory() {
        return factory;
    }

    public void setFactory(MainFactory factory) {
        this.factory = factory;
    }

    public List<PinballElement> getElements() {
        return elements;
    }

    public void setElements(List<PinballElement> elements) {
        this.elements = elements;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

}
