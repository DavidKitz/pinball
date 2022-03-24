package com.example.pinball.status;

import com.example.pinball.TheGame.Pinball;

public class Ready extends Status{

    public Ready() {
    }

    @Override
    public void addCoin(Pinball pinball) {
        super.addCoin(pinball);
    }

    @Override
    public void start(Pinball pinball) {
        pinball.setStatus(new Playing());
        if (pinball.getCredit() > 0) {
            pinball.setCredit(pinball.getCredit() - 1);
            pinball.setBalls(3);
            System.out.println("Let's play!!");
        } else {
            pinball.setStatus(new NoCredit());
            System.out.println("THERE IS NO CREDIT!");
        }
    }
}
