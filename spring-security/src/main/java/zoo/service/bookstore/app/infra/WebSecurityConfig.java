package zoo.service.bookstore.app.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import zoo.service.bookstore.app.infra.config.adapter.WebConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Bean
    public WebConfigurerAdapter webConfigurerAdapter() {
        return new WebConfigurerAdapter();
    }

}