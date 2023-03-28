package zoo.springframework.security.service.web.auth;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/denied")
    public void authDenied() {
    }

    @GetMapping("/fail")
    public void authFail() {
    }

}