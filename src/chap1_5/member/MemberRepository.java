package chap1_5.member;

// 회원들의 CRUD를 담당하는 창고(데이터베이스) 역할
public class MemberRepository {

    // 회원들을 저장할 배열
    // String[] => ['','','']
    // int[] => [10,20,30]
    // Member[] => [{id:'',memberName:'', ... },{}.{}]
    Member[] memberList; // 가입된 회원 배열

    MemberRepository() {
        memberList = new Member[] {
                new Member(15,"abc123@def.com", "1234", "콩벌레", Gender.MALE)
                , new Member(25,"ffff@ggg.com", "5678", "팥죽이", Gender.FEMALE)
                , new Member(35,"xxx@ccc.com", "9089", "카레빵", Gender.FEMALE)
        };
    }

    // 메서드

    // 회원 배열을 리턴하는 메서드
    Member[] getMembers() {
        return this.memberList;
    }
}
