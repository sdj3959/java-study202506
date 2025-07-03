package chap2_1.exception;

public class Main {
    public static void main(String[] args) {

        // 회원 생성
        LoginUser user = new LoginUser("abc123", "1234");

        // 로그인 검증
        try {
            user.authenticate("abc111", "9999");
        } catch (Exception e) {

        }
    }
}
