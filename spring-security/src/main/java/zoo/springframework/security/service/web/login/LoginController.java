package zoo.springframework.security.service.web.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * issue: UI 페이지 렌더링 컨트롤러와 비동기 통신 컨트롤러의 책임 분리에 대한 고민
 * UI를 보여주는 LoginPageController, UI와 Ajax와 같은 비동기 통신할 LoginRestController로
 * 책임을 분리하는 것에 대해 한번 생각해 보자
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public void loginPage() {
    }

    @PostMapping
    public void loginProcessPage() {
    }

    @GetMapping("/fail")
    public void loginFail() {
    }

    @GetMapping("/succeed")
    public void loginSucceed() {
    }

}