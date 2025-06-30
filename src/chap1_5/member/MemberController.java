package chap1_5.member;

import java.util.Scanner;

// 역할: 회원관리 앱의 입출력을 담당
public class MemberController {

    // 객체의 협력과 위임
    // 필드: 클래스의 속성 - 부품 속성
    MemberRepository mr; // 의존관계
    Scanner sc;

    MemberController() {
        mr = new MemberRepository();
        sc = new Scanner(System.in);
    }

    // 프로그램 초기 화면 출력
    void start() {
        while (true) {
            processMenu(showMenu());
        } // end while
    }

    /**
     * 사용자가 입력한 메뉴 번호에 따라 해당하는 회원 관리 기능을 실행하는 메서드입니다.
     *
     * @param menuNum 사용자가 선택한 메뉴 번호를 나타내는 문자열
     */
    void processMenu(String menuNum) {
        switch (menuNum) {
            case "1":
                signUp();
                break;
            case "2":
                showAllMembers();
                break;
            case "3":
                showDetailMember();
                break;
            case "4":
                changePassword();
                break;
            case "5":
                deleteMember();
                break;
            case "6":
                restoreMember();
                break;
            case "7":
                System.out.println("\n# 프로그램을 종료합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("# 메뉴를 다시 입력해주세요!");
        }// end switch

        prompt("======== 계속하시려면 Enter... =========");
    }

    void deleteMember() {
        // 이메일을 입력받고 있으면 패스워드도 입력받아서 삭제
        System.out.println("\n# 회원 정보를 삭제합니다.");
        Member foundMember = findMember("삭제");

        if (foundMember != null) {
            // 삭제 전에 패스워드를 확인
            String inputPassword = prompt("# 비밀번호: ");
            if (foundMember.isPasswordMatch(inputPassword)) {
                // 실제 삭제 진행
                mr.removeMember(foundMember.email);
                System.out.println("\n# 회원 탈퇴처리가 완료되었습니다!");
            } else {
                System.out.println("\n# 비밀번호가 틀렸습니다. 삭제를 취소합니다.");
            }
        } else {
            System.out.println("\n# 조회 결과가 없습니다!");
        }
    }

    void changePassword() {
        System.out.println("\n# 회원 정보를 패스워드를 수정합니다.");
        Member foundMember = findMember("수정");

        if (foundMember != null) {
            // 비밀번호 수정 진행
            String newPassword = prompt("# 새 비밀번호 : ");

            // 실질적인 데이터 수정 처리
            foundMember.updateNewPassword(newPassword);

            System.out.println("\n# 변경이 완료되었습니다.");

        } else {
            System.out.println("\n# 조회 결과가 없습니다!");
        }
    }

    Member findMember(String message) {
        String email = prompt("# %s 대상의 이메일: ".formatted(message));
        return mr.findMemberByEmail(email);
    }

    void showDetailMember() {
        System.out.println("\n# 회원 개별조회를 시작합니다.");
        Member foundMember = findMember("조회");
        if (foundMember != null) {
            // 개별정보 출력
            foundMember.inform();
        } else {
            System.out.println("\n# 조회 결과가 없습니다!");
        }
    }

    void signUp() {
        System.out.println("\n# 회원 정보 등록을 시작합니다.");
        String email = checkDuplicateEmail();
        String password = prompt("# 패스워드: ");
        String memberName = prompt("# 이름: ");
        Gender gender = inputCorrectGender();
        String ageStr = prompt("# 나이: ");

        // 회원 배열에 추가
        mr.addMember(new Member(
                Integer.parseInt(ageStr),
                email,
                password,
                memberName,
                gender
        ));

        System.out.println("\n# 회원가입에 성공했습니다.");
    }

    /**
     * 사용자로부터 이메일을 입력받고, 해당 이메일이 중복되지 않을 때까지 반복하여 입력받는 메서드입니다.
     *
     * 이 메서드는 이메일이 중복되지 않은 경우 해당 이메일을 반환합니다.
     *
     * @return 사용자로부터 입력받은 중복되지 않은 이메일 문자열
     */
    String checkDuplicateEmail() {
        while (true) {
            String email = prompt("# 이메일: ");
            if (!mr.isDuplicateEmail(email)) {
                // 중복이 아닌 경우
                return email;
            }
            System.out.println("# 이메일이 중복되었습니다.");
        }
    }

    /**
     * 사용자로부터 올바른 성별을 입력받아 반환하는 메서드입니다.
     *
     * 이 메서드는 지속적으로 사용자에게 "M" 또는 "F"를 입력하도록 요청하며,
     * 유효한 입력 값을 받을 때까지 반복합니다. 입력 값이 대소문자 구분 없이
     * 처리되며, "M"은 MALE, "F"는 FEMALE로 매핑됩니다.
     *
     * @return Gender 사용자가 입력한 성별을 나타내는 열거형 값 (MALE 또는 FEMALE)
     */
    Gender inputCorrectGender() {
        while (true) {
            String genderStr = prompt("# 성별 [M/F] : "); // man
            switch (genderStr.toUpperCase().charAt(0)) {
                case 'M':
                    return Gender.MALE;
                case 'F':
                    return Gender.FEMALE;
                default:
                    System.out.println("# 성별을 M 또는 F로 입력해주세요!");
            }
        }
    }


    /**
     * 전체 회원 목록을 출력하는 메서드입니다.
     *
     * 이 메서드는 {@code MemberRepository} 객체를 통해 저장된 모든 회원 정보를 가져와
     * 출력 형식에 따라 콘솔에 표시합니다.
     *
     * 기능:
     * 1. 회원 목록 데이터를 조회합니다.
     * 2. 콘솔에 회원 정보를 출력합니다.
     */
    void showAllMembers() {
        System.out.println("\n# 전체 회원 정보를 조회합니다.");
        Member[] members = mr.getMembers();
        for (Member member : members) {
            member.inform();
        }
    }

    /**
     * 회원 관리 시스템의 메뉴를 출력하고 사용자가 선택한 메뉴 번호를 입력받아 반환하는 메서드입니다.
     *
     * @return 사용자가 선택한 메뉴 번호를 나타내는 문자열
     */
    String showMenu() {
        System.out.printf("\n#####  회원 관리 시스템 (현재 회원 수: %d명)  #####\n", mr.size());
        System.out.println("* 1. 회원 정보 등록하기");
        System.out.println("* 2. 전체 회원 조회하기");
        System.out.println("* 3. 개별 회원 조회하기");
        System.out.println("* 4. 회원 정보 수정하기");
        System.out.println("* 5. 회원 정보 삭제하기");
        System.out.println("* 6. 회원 정보 복구하기");
        System.out.println("* 7. 프로그램 종료하기");
        System.out.println("================================");
        return prompt(">> ");
    }

    /**
     * 사용자로부터 입력 메시지를 출력하며 데이터를 입력 받는 메서드입니다.
     *
     * @param message 입력을 요청하며 출력할 메시지
     * @return 사용자가 입력한 문자열
     */
    String prompt(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    void restoreMember() {
        String inputEmail = prompt("# 복구 대상의 이메일: ");
        // 복구 대상 탐색 및 복구 처리
        boolean flag = mr.restore(inputEmail);

        if (flag) {
            System.out.println("\n# 복구처리가 완료되었습니다.");
        } else {
            System.out.println("\n# 복구에 실패했습니다.");
        }
    }
}
