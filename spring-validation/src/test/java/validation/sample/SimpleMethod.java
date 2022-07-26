package validation.sample;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
public class SimpleMethod {

    @Valid
    public void validationInt(@Valid @Min(1) int param1){

    }

}
