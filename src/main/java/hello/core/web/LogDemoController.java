package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.logdemo.LogDemoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo") //"/log-domo" URL에 대한 요청을 처리하도록 매핑
    @ResponseBody //반환값을 예쁘게(HTML, JSP 등) 포장하지 않고 바로 택배상자에 넣기(JSON, XML 등)
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI().toString(); //요청 URL을 추출한다. ex)http://localhost:8080/log-demo

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL); //추출한 URL을 현재 요청에 할당된 MyLogger 인스턴스에 저장한다.

        myLogger.log("controller test"); //로그에 메시지를 남김
        logDemoService.logic("testId");
        return "OK"; //HTTP 응답으로 "OK" 문자열 반환
    }
}
