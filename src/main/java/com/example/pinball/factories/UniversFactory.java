package com.example.pinball.factories;

public class UniversFactory implements MainFactory{

    private Ball ball1 = new Ball1();
    private Ball ball2 = new Ball2();
    private Ball ball3 = new Ball3();
    private GameOver gameOver = new GameOver1();

    public UniversFactory() {
    }


    @Override
    public String createBall1() {
        return ball1.showBall();
    }

    @Override
    public String createBall2() {
        return ball2.showBall();
    }

    @Override
    public String createBall3() {
        return ball3.showBall();
    }

    @Override
    public String createGameOver() {
        return gameOver.showGameOver();
    }
}
