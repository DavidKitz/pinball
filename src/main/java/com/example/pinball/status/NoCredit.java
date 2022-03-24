package com.example.pinball.status;

import com.example.pinball.TheGame.Pinball;

public class NoCredit extends Status {

    public NoCredit() {
    }

    @Override
    public void addCoin(Pinball pinball) {
        pinball.setStatus(new Ready());
        super.addCoin(pinball);
    }

    @Override
    public void start(Pinball pinball) {
        super.start(pinball);
    }
}
