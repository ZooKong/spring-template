package zoo.security.jwt.algorithms.asserts.support;

import org.junit.jupiter.api.Assertions;


public class TokenPatternTest {
    private static final String separatorRegex = "\\.";

    public static void 토큰_문자열_3개_요소_존재_확인(String token) {
        if (token.split(separatorRegex).length == 3) {
            Assertions.fail("A token must have three components: Header, Payload, and Signature.");
        }
    }

}