package zoo.security.jwt.dto;

public interface Claims {

    HeaderClaims headerClaims();

    PayloadClaims payloadPublicClaims();

}