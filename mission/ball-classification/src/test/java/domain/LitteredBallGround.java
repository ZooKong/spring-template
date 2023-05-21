package domain;

import java.util.Queue;

public class LitteredBallGround {
    private final Queue<Ball> balls;
    private final int size;

    LitteredBallGround(Queue<Ball> balls) {
        this.balls = balls;
        this.size = balls.size();
    }

    public Ball getBall() {
        return balls.poll();
    }
}