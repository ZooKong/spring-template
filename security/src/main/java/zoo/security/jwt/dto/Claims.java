package zoo.security.jwt.dto;

public interface Claims {

    HeaderClaims headerClaims();

    PayloadPrivateClaims payloadPrivateClaims();

    PayloadPublicClaims payloadPublicClaims();

}