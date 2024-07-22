package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //이름 그대로 @Component가 붙은 녀석을 스캔해서 스프링빈으로 스프링컨테이너에 넣어준다.
        basePackages = "hello.core.member", //명시한 패키지를 탐색 시작 위치를 지정
        basePackageClasses = AutoAppConfig.class, //지정한 클래스가 속한 패키지를 탐색 시작 위치로 지정. 여기서는 hello.core가 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //제외할 대상 설정
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
