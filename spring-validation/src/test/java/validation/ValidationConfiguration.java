package validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import validation.sample.SimpleMethod;

@Configuration
@ComponentScan(basePackages = "validation.sample")
public class ValidationConfiguration {

    @Bean
    public SimpleMethod simpleMethod() {
        return new SimpleMethod();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}