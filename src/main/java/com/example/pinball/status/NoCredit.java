package com.example.pinball.status;

import com.example.pinball.TheGame.Pinball;

public class NoCredit extends Status{

    public NoCredit() {
    }

    @Override
    public String addCoin(Pinball pinball) {
        pinball.setStatus(new Ready());
        return super.addCoin(pinball);
    }

    @Override
    public String start(Pinball pinball) {
        return super.start(pinball);
    }
}
