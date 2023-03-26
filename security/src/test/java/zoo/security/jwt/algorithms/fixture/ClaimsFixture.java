package zoo.security.jwt.algorithms.fixture;

import zoo.security.jwt.dto.Claims;
import zoo.security.jwt.dto.HeaderClaims;
import zoo.security.jwt.dto.PayloadClaims;

import java.util.HashMap;
import java.util.Map;

public class ClaimsFixture implements Claims {

    @Override
    public HeaderClaims headerClaims() {
        return new HeaderClaims() {
            @Override
            public String ver() {
                return "v1";
            }

            @Override
            public String typ() {
                return "JWT";
            }

            @Override
            public String alg() {
                return "RS256";
            }
        };
    }

    @Override
    public PayloadClaims payloadPublicClaims() {
        return new PayloadClaims() {
            @Override
            public String iss() {
                return "name01";
            }

            @Override
            public int exp() {
                return 100;
            }

            @Override
            public int iat() {
                return 100;
            }

            @Override
            public Map<String, Object> pvt() {
                Map<String, Object> pvt = new HashMap<>();
                pvt.put("field1", 1);
                pvt.put("field2", 2);
                return pvt;
            }
        };
    }
}
