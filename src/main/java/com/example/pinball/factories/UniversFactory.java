package com.example.pinball.factories;

public class UniversFactory implements MainFactory{

    private Ball ball;
    private int balls = 3;

    public UniversFactory() {
    }


    @Override
    public String createBall1() {
        Ball ball1 = new Ball1();
        return ball1.showBall();
    }

    @Override
    public String createBall2() {
        Ball ball2 = new Ball2();
        return ball2.showBall();
    }

    @Override
    public String createBall3() {
        Ball ball3 = new Ball3();
        return ball3.showBall();
    }

    @Override
    public String createGameOver() {
        GameOver gameOver = new GameOver1();
        return gameOver.showGameOver();
    }
}
