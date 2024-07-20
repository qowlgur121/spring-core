package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //저장소이니까 저장할 공간이 필요하다. Map정도가 적당해보인다.
    private static Map<Long, Member> store = new HashMap<>(); //한번만 생성해야 하기 때문에 static으로...

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
