package zoo.security.jwt.provider;

@FunctionalInterface
public interface SecretProvider {

    String provide();

}