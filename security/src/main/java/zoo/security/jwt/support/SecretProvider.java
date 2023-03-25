package zoo.security.jwt.support;

@FunctionalInterface
public interface SecretProvider {

    String provide();

}