package zoo.security.jwt.support;

import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class DecodedClaims {

    private final DecodedJWT decodedJWT;

    public DecodedClaims(DecodedJWT decodedJWT) {
        this.decodedJWT = decodedJWT;
    }

    public String getVer() {
        return decodedJWT.getHeaderClaim(PrivateClaims.VERSION).asString();
    }

    public String getType() {
        return decodedJWT.getType();
    }

    public String getAlgorithm() {
        return decodedJWT.getAlgorithm();
    }

    public Date getExpiresAt() {
        return decodedJWT.getExpiresAt();
    }

    public Date getIssuedAt() {
        return decodedJWT.getIssuedAt();
    }

    public String getIssuer() {
        return decodedJWT.getIssuer();
    }

    public Map<String, Object> getPrivate() {
        return decodedJWT.getClaim(PrivateClaims.PRIVATE).asMap();
    }

}