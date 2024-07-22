package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링에서는 이런 설정정보에 @Configuration을 적어주게 되어있다.
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //즉 같은 이름의 인스턴스 생성을 호출하게 된다. 싱글톤 패턴 무너지는 거 아닌가?

    @Bean
    public MemberService memberService() { //public으로 하자
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); //스프링 빈. 이제 스프링 컨테이너에서 관리된다.
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        //return new OrderServiceImpl(memberRepository(), discountPolicy()); //이걸 다시 살리자. 테스트때문에 주석처리함
        return null;

    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository(); //스프링 빈. @Bean이 붙은 메서드에서 반환한 객체를 "스프링 빈"이라 한다.
    }

    @Bean
    public static DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
