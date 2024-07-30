package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    //스프링의 request스코프를 사용하여 각 웹 요청마다 고유한 로그 메시지를 출력하기 위한 클래스

    private String uuid; //Mylogger 객체가 생성될 때마다 생성되는 유니크 아이디
    private String requestURL; //요청된 웹 요청의 주소

    public void setRequestURL(String requestURL) { //MyLogger 인스턴스와 특정 웹 요청과 연결
        this.requestURL = requestURL;
    }

    public void log(String message) { //콘솔에 로그 출력
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() { //스프링 빈 생성 후 바로 유니크 아이디 생성
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void destroy() { //빈 소멸 직전에 소멸 메시지 출력
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}
