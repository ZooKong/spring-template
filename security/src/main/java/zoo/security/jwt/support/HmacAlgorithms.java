package zoo.security.jwt.support;

import com.auth0.jwt.algorithms.Algorithm;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static zoo.security.jwt.support.HmacBitsType.*;

public class HmacAlgorithms {

    private final Charset charset = StandardCharsets.UTF_8;
    private final Map<HmacBitsType, Algorithm> algorithms;
    private final String secret;
    private final byte[] secretBytes;

    public static HmacAlgorithms bySecret(String secret) {
        return new HmacAlgorithms(secret);
    }

    private HmacAlgorithms(String secret) {
        this.secret = secret;
        this.secretBytes = getSecretBytes();
        this.algorithms = getAlgorithms();
    }

    public Algorithm getAlgorithm(HmacBitsType bitsType) {
        return algorithms.get(bitsType);
    }

    private byte[] getSecretBytes() {
        return this.secret.getBytes(charset);
    }

    public Map<HmacBitsType, Algorithm> getAlgorithms() {
        Map<HmacBitsType, Algorithm> result = new HashMap<>();
        result.put(HS256, getHmac256Algorithm());
        result.put(HS384, getHmac384Algorithm());
        result.put(HS512, getHmac512Algorithm());
        return result;
    }

    private Algorithm getHmac256Algorithm() {
        return Algorithm.HMAC256(this.secretBytes);
    }

    private Algorithm getHmac384Algorithm() {
        return Algorithm.HMAC384(this.secretBytes);
    }

    private Algorithm getHmac512Algorithm() {
        return Algorithm.HMAC512(this.secretBytes);
    }

}