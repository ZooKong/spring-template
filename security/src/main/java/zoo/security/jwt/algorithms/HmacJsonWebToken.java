package zoo.security.jwt.algorithms;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.PublicClaims;
import zoo.security.jwt.dto.Claims;
import zoo.security.jwt.dto.HeaderClaims;
import zoo.security.jwt.dto.PayloadClaims;
import zoo.security.jwt.support.DecodedClaims;
import zoo.security.jwt.support.HmacAlgorithms;
import zoo.security.jwt.support.HmacBitsType;
import zoo.security.jwt.provider.SecretProvider;
import zoo.security.jwt.support.PrivateClaims;

import java.util.HashMap;
import java.util.Map;


public class HmacJsonWebToken {

    // for debugger
    private final String secret;
    private final Algorithm algorithm;

    public HmacJsonWebToken(SecretProvider provider, HmacBitsType bitsType) {
        this(provider.provide(), bitsType);
    }

    public HmacJsonWebToken(String secret, HmacBitsType bitsType) {
        this.secret = secret;
        HmacAlgorithms hmacAlgorithms = HmacAlgorithms.bySecret(secret);
        this.algorithm = hmacAlgorithms.getAlgorithm(bitsType);
    }

    public String generate(Claims claims) {
        HeaderClaims headerClaims = claims.headerClaims();
        PayloadClaims payloadClaims = claims.payloadPublicClaims();

        JWTCreator.Builder jwtBuilder = JWT.create();
        setHeader(jwtBuilder, headerClaims);
        setPayloadClaims(jwtBuilder, payloadClaims);

        return jwtBuilder.sign(this.algorithm);
    }

    public void verify(String token) {
        JWTVerifier verifier = JWT.require(this.algorithm).build();
        verifier.verify(token);
    }

    public DecodedClaims decode(String token) {
        return new DecodedClaims(JWT.decode(token));
    }

    private void setHeader(JWTCreator.Builder jwtBuilder, HeaderClaims headerClaims) {
        jwtBuilder.withHeader(getHeader(headerClaims));
    }

    private Map<String, Object> getHeader(HeaderClaims headerClaims) {
        return new HashMap<String, Object>() {{
            put(PublicClaims.TYPE, headerClaims.typ());
            put(PublicClaims.ALGORITHM, headerClaims.alg());
            put(PrivateClaims.VERSION, headerClaims.ver());
        }};
    }

    private void setPayloadClaims(JWTCreator.Builder jwtBuilder, PayloadClaims payloadClaims) {
        jwtBuilder
                .withClaim(PublicClaims.ISSUER, payloadClaims.iss())
                .withClaim(PublicClaims.EXPIRES_AT, payloadClaims.exp())
                .withClaim(PublicClaims.ISSUED_AT, payloadClaims.iat())
                .withClaim(PrivateClaims.PRIVATE, payloadClaims.pvt());
    }

}