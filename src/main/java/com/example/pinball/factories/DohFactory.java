package com.example.pinball.factories;

public class DohFactory implements MainFactory {
    @Override
    public String createBall1() {
        Ball ball1 = new Ball12();
        return ball1.showBall();
    }

    @Override
    public String createBall2() {
        Ball ball2 = new Ball22();
        return ball2.showBall();
    }

    @Override
    public String createBall3() {
        Ball ball3 = new Ball32();
        return ball3.showBall();
    }

    @Override
    public String createGameOver() {
        GameOver gameOver = new GameOver2();
        return gameOver.showGameOver();
    }
}
