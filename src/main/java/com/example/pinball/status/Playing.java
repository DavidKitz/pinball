package com.example.pinball.status;

import com.example.pinball.TheGame.Pinball;

public class Playing extends Status {

    public Playing() {
    }

    @Override
    public String addCoin(Pinball pinball) {
        return super.addCoin(pinball);
    }

    @Override
    public String start(Pinball pinball) {
        pinball.setStatus(this);
        return "Developed by: Rajeh Abdulhadi & David Kitz";
    }

}