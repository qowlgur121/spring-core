package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    //가입하고 조회를 하려면 저장소가 필요하다
    private final MemberRepository memberRepository;

    @Autowired //자동으로 의존관계 주입이 된다. 스프링 컨테이너에 있는 MemberRepository타입에 맞는 스프링빈을 넣어준다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
