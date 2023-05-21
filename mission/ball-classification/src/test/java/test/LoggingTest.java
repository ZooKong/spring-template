package test;

import domain.Bag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class LoggingTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);

    private static long startTime = 0;

    protected void logBags(Map<Integer, Bag> bags) {
        bags.entrySet().forEach((bagEntry) -> {
            int bagNumber = bagEntry.getKey();
            Bag bag = bagEntry.getValue();

            logger.debug(
                    "bag number = {} / bag size = {} / bag total sum = {}"
                    , bagNumber
                    , bag.getSize()
                    , bag.getTotalSum()
            );
        });
    }

    protected void checkStartTime() {
        startTime = System.currentTimeMillis();
    }

    protected void logTotalTimeSpent() {
        logger.debug("total time spent = {}", System.currentTimeMillis() - startTime);
    }


}
