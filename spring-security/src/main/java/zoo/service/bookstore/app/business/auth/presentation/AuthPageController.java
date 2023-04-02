package zoo.service.bookstore.app.business.auth.presentation;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class AuthPageController {

    @GetMapping("/fail")
    public void fail() {
    }

    @GetMapping("/denied")
    public void denied() {
    }

    @GetMapping("/admin")
    @ResponseBody
    @PreAuthorize("isAuthenticated() and hasAuthority('admin')")
    public String admin() {
        return "1";
    }

    @GetMapping("/manager")
    @ResponseBody
    @PreAuthorize("isAuthenticated() and hasAuthority('manager')")
    public String manager() {
        return "1";
    }

    @GetMapping("/user")
    @ResponseBody
    @PreAuthorize("isAuthenticated() and hasAuthority('user')")
    public String user() {
        return "1";
    }

}