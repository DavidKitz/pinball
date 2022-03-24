package com.example.pinball.factories;

public class DohFactory implements MainFactory {
    private Ball ball1 = new Ball12();
    private Ball ball2 = new Ball22();
    private Ball ball3 = new Ball32();
    private GameOver gameOver = new GameOver2();

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
