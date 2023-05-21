package domain;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final List<Ball> balls = new ArrayList<>();

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public int getSize() {
        return balls.size();
    }

    public int getTotalSum() {
        int totalSum = 0;

        for (Ball ball : balls) {
            totalSum += ball.getNumber();
        }

        return totalSum;
    }
}