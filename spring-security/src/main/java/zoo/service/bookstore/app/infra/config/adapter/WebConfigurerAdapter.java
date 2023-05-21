package zoo.service.bookstore.app.infra.config.adapter;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import zoo.service.bookstore.app.infra.config.provider.FormAuthenticationProvider;

public class WebConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authenticationProvider(new FormAuthenticationProvider());
//        http.userDetailsService();
//        http.passwordManagement();
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .successHandler((request, response, authentication) -> {
                    response.sendRedirect("/login/succeed");
                })
                .failureUrl("/login/fail");

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        http.exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    response.sendRedirect("/auth/fail");
                })
                .accessDeniedPage("/auth/denied");
    }

}