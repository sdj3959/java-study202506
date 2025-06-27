package chap1_5.member;

import java.time.LocalDateTime;
import java.util.UUID;

// 역할: 회원 한 명의 회원 정보를 잘 가지고 있어야 함.
public class Member {
    String email; // 본질 식별자
    String password;
    String memberName;
    String id; // 인조 식별자 (랜덤값: 시스템이 자동생성)
    Gender gender;
    int age;
    LocalDateTime registerDate; // 회원가입 일시

    // 생성자 : 객체가 처음 생성될 때 필드를 초기화
    public Member(int age, String email, String password, String memberName, Gender gender) {
        this.age = age;
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.gender = gender;
        this.id = UUID.randomUUID().toString();
        this.registerDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Member{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", memberName='" + memberName + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", registerDate=" + registerDate +
                '}';
    }
}
