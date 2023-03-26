package zoo.security.jwt.dto;

import java.util.Map;

public interface PayloadClaims {

    String iss();

    int exp();

    int iat();

    Map<String, Object> pvt();

}