package zoo.service.bookstore.app.infra.config.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
// TODO: ProviderManager와 어떤 관계인지 확인하고 정리하자
public class FormAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePassword = (UsernamePasswordAuthenticationToken) authentication;

        // 유저가 인증을 위해 넘긴 값
        String userId = usernamePassword.getName();
        String userPw = (String) usernamePassword.getCredentials();

        // issue: 단방향 암호화를 통해 password를 암호화하여 DB에 있는 값과 비교할 수 있다.
        // UserDto userDto = UserDto.byIdAndPassword(userId, userPw);

        /**
         * 해당 부분에서 Exception을 발생시킬 때, ProviderManager를 참고하는 것이 좋음
         * 만약, Authentication와 관련된 Fail 처리를 하고 싶으면 아래의 Exception을 참고.
         * AccountStatusException, InternalAuthenticationServiceException, AuthenticationException
         * 위의 3가지 Exception을 catch 하고 있기 때문에 이외의 Exception은 서버의 500에러로 핸들링 함.
         */


        //  이것을 반환하는 리드스
        // username-parameter="userid"
        // password-parameter="userpw"
        // Object principal, Object credentials,
        //			Collection<? extends GrantedAuthority> authorities
        /**
         * principal
         * credentials
         * authorities, SimpleGrantedAuthority를 통해 반환.. GrantedAuthority
         */
        return new UsernamePasswordAuthenticationToken(
                userId,
                userPw,
                getMatchingAuthoritys(userId, userPw)
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private Set<GrantedAuthority> getMatchingAuthoritys(String userId, String userPw) {
        String roleName = UserFixture.getMatchingRole(userId, userPw);
        return new HashSet<>(Arrays.asList(new SimpleGrantedAuthority(roleName)));
    }

    private enum UserFixture {
        ADMIN("zookong-admin", "zookong-admin", "admin"),
        MANAGER("zookong-manager", "zookong-manager", "manager"),
        USER("zookong-user", "zookong-user", "user");

        private String id;
        private String pw;
        private String role;

        UserFixture(String id, String pw, String role) {
            this.id = id;
            this.pw = pw;
            this.role = role;
        }

        private boolean equalId(String id) {
            return this.id.equals(id);
        }

        private boolean equalPw(String pw) {
            return this.pw.equals(pw);
        }

        private String getRole() {
            return new String(this.role);
        }

        public static String getMatchingRole(String id, String pw) {
            for (UserFixture fixture : values()) {
                if (fixture.equalId(id) && fixture.equalPw(pw)) {
                    return fixture.getRole();
                }
            }
            return null;
        }
    }

}
