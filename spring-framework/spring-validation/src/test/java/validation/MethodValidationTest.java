package validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import validation.sample.GreetingService;
import validation.sample.SimpleMethod;

@SpringBootTest(classes = ValidationConfiguration.class)
public class MethodValidationTest {

    @Autowired
    private SimpleMethod simpleMethod;

    @Autowired
    private GreetingService greetingService;

    @Test
    void test() {
        simpleMethod.validationInt(-1);
    }

}