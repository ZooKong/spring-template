package zoo.springframework.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import zoo.springframework.security.config.auth.provider.FormAuthenticationProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
public class WebConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Bean
    public FormAuthenticationProvider formAuthenticationProvider() {
        return new FormAuthenticationProvider();
    }

    // 스프링 시큐리티 규칙
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // iframe 허용안함.
        http.headers().frameOptions().disable();

        // csrf 보안 설정 비활성화
        // TODO: 왜 비활성화를 해야할까?
        http.csrf().disable();

        http.authorizeRequests()
                // login page에 대해 전부 접근 허용
                .antMatchers("/login", "/static/**").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/admin/restricted/**").hasRole("restricted")
                .antMatchers("/admin/general/**").hasAnyRole("restricted", "general");

        http.formLogin()
                .loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password")
                .successHandler((request, response, authentication)->{
                    response.sendRedirect("/login/succeed");
                })
                .loginProcessingUrl("/login")
                .failureUrl("/login/fail");

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout/succeed")
                // logout할 경우 HttpSession을 무효화할지 여부
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONIDdd");

        http.exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    response.sendRedirect("/auth/fail");
                })
                .accessDeniedPage("/auth/denied");
    }

}