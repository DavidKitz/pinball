package com.example.pinball.status;

import com.example.pinball.TheGame.Pinball;

public abstract class Status {

    public Status() {
    }

    public void addCoin(Pinball pinball) {
        pinball.setCredit(pinball.getCredit() + 1);
        System.out.println("Coin added!! You have: " + pinball.getCredit() + " credit(s)");
    }

    public void start(Pinball pinball) {
        if (pinball.getCredit() > 0) {
            pinball.setStatus(new Ready());
            System.out.println("Press PLAY to start!");
        } else {
            pinball.setStatus(new NoCredit());
            System.out.println("Sorry.. there is no credit :(");
        }
    }

}
