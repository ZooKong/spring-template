package zoo.service.bookstore.app.business.error.presentation;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping("/error")
    public String errorPage(HttpServletRequest request) {
        // request 객체에서 서블릿 에러 상태 코드를 얻을 수 있음
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        return "/error/" + status;
    }

}
