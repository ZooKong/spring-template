package zoo.springframework.security.service.web.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * 기본적으로 에러에 대한 컨트롤러는 BasicErrorController에 구현되어 있음
 *
 * ErrorController를 상속받지 않은 컨트롤러에
 * @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)를 사용하면
 * 이미 BasicErrorController에 정의가 되어 있어서 중복 정의에 의한 Exception이 Spring 구동시에 발생함
 */
@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping("/error")
    public String errorPage(HttpServletRequest request) {
        // request 객체에서 서블릿 에러 상태 코드를 얻을 수 있음
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        return "error";
    }

}