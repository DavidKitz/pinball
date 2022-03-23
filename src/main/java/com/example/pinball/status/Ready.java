package com.example.pinball.status;

import com.example.pinball.TheGame.Pinball;

public class Ready extends Status{

    public Ready() {
    }

    @Override
    public String addCoin(Pinball pinball) {
        return super.addCoin(pinball);
    }

    @Override
    public String start(Pinball pinball) {
        pinball.setStatus(new Playing());
        if (pinball.getCredit() > 0) {
            pinball.setCredit(pinball.getCredit() - 1);
            pinball.setBalls(3);
            return "Let's play!!";
        } else {
            pinball.setStatus(new NoCredit());
            return "THERE IS NO CREDIT!";
        }
    }
}
