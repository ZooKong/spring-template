package domain;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LitteredBallGroundGenerator {
    private final static int size = 10000000;

    public static LitteredBallGround generate() {
        return new LitteredBallGround(getBalls());
    }

    private static Queue<Ball> getBalls() {
        Queue<Ball> balls = new ConcurrentLinkedQueue<>();
        for (int seq = 0; seq < size; seq++) {
            balls.add(new Ball(getBallNumber(seq)));
        }
        return balls;
    }

    private static int getBallNumber(int sequence) {
        return sequence % 10 + 1;
    }
}