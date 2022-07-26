package validation.sample;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Service
public class HelloGreetingService implements GreetingService {

    @Override
    public String greet(@NotNull @NotBlank  String greeting) {
        return null;
    }

}