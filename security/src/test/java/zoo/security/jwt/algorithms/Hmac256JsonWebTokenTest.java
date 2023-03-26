package zoo.security.jwt.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zoo.security.jwt.algorithms.asserts.support.TokenPatternTest;
import zoo.security.jwt.algorithms.fixture.ClaimsFixture;
import zoo.security.jwt.support.HmacBitsType;

/**
 * HmacJsonWebTokenTest
 */
public class Hmac256JsonWebTokenTest {

    private final HmacBitsType bitsType = HmacBitsType.HS256;
    private final HmacJsonWebToken jsonWebToken = new HmacJsonWebToken("secret", bitsType);

    @BeforeEach
    void setUp() {
        // 1. Header
        // 2. Payload
    }

    // 1. 토큰 생성
    @Test
    void createToken() {
        String token = jsonWebToken.generate(new ClaimsFixture());
        TokenPatternTest.토큰_문자열_3개_요소_존재_확인(token);
    }



}
