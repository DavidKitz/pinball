package com.example.pinball.status;

import com.example.pinball.TheGame.Pinball;

public abstract class Status {

    public Status() {
    }

    public String addCoin(Pinball pinball) {
        pinball.setCredit(pinball.getCredit() + 1);
        return "Coin added!! You have: " + pinball.getCredit() + " credit(s)";
    }

    public String start(Pinball pinball) {
        if (pinball.getCredit() > 0) {
            pinball.setStatus(new Ready());
            return "Press PLAY to start!";
        } else {
            pinball.setStatus(new NoCredit());
            return "Sorry.. there is no credit :(";
        }
    }

}
