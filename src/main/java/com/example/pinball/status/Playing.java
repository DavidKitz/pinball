package com.example.pinball.status;

import com.example.pinball.TheGame.Pinball;

public class Playing extends Status {

    public Playing() {
    }

    @Override
    public void addCoin(Pinball pinball) {
        super.addCoin(pinball);
    }

    @Override
    public void start(Pinball pinball) {
        pinball.setStatus(this);
        System.out.println("Developed by: Rajeh Abdulhadi & David Kitz");
    }

}