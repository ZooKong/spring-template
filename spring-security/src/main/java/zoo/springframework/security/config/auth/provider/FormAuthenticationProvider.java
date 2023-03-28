package zoo.springframework.security.config.auth.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import zoo.springframework.security.dto.UserDto;

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
        UserDto userDto = UserDto.byIdAndPassword(userId, userPw);

        /**
         * 해당 부분에서 Exception을 발생시킬 때, ProviderManager를 참고하는 것이 좋음
         * 만약, Authentication와 관련된 Fail 처리를 하고 싶으면 아래의 Exception을 참고.
         * AccountStatusException, InternalAuthenticationServiceException, AuthenticationException
         * 위의 3가지 Exception을 catch 하고 있기 때문에 이외의 Exception은 서버의 500에러로 핸들링 함.
         */

        // username-parameter="userid"
        // password-parameter="userpw"

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // UsernamePasswordAuthenticationToken : 간단한 username 과 password를 통한 인증 토큰 클래스
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
