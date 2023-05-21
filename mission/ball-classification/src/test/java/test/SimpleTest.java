package test;

import domain.Bag;
import domain.Ball;
import domain.LitteredBallGround;
import domain.LitteredBallGroundGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SimpleTest extends LoggingTest {

    @Test
    void test() {
        LitteredBallGround ballGround = LitteredBallGroundGenerator.generate();

        Map<Integer, Bag> bags = new HashMap<>();
        int bagCnt = 5;

        checkStartTime();

        classify(ballGround, bags, bagCnt);

        logTotalTimeSpent();
        logBags(bags);
    }

    private void classify(LitteredBallGround ballGround, Map<Integer, Bag> bags, int bagCnt) {
        while (true) {
            Ball ball = ballGround.getBall();

            // 더 이상 공이 없으면 while 문 종료
            if (ball == null) {
                break;
            }

            // 공 번호와 공 번호에 대응하는 가방 번호 구하기
            int ballNumber = ball.getNumber();
            int bagNumber = ballNumber % bagCnt + 1;

            // 공의 번호에 대응하는 가방이 없을 경우 생성
            if (!bags.containsKey(bagNumber)) {
                bags.put(bagNumber, new Bag());
            }

            // 대응하는 가방을 찾아 가방에 공을 담기
            Bag bag = bags.get(bagNumber);
            bag.addBall(ball);
        }
    }

}
