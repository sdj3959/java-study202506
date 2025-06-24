package chap1_2.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz03 {
    public static void main(String[] args) {

        // 멤버 이름 삭제

        Scanner sc = new Scanner(System.in);

        String[] members = {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};

        while (true) {
            System.out.println("삭제할 이름을 입력하세요");
            System.out.print(">> ");
            String input = sc.nextLine();

            boolean isExist = false;
            int idx = 0;

            for (int i = 0; i < members.length; i++) {
                if (input.equals(members[i])) {
                    isExist = true;
                    idx = i;
                    break;
                }
            }

            if (!isExist) {
                System.out.println(input+"는(은) 없는 이름입니다.");
            } else {
                for (int i = idx; i < members.length-1; i++){
                    members[i] = members[i+1];
                }
                String[] temp = new String[members.length - 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = members[i];
                }
                members = temp;
                temp = null;
                System.out.println("- 삭제 후 배열: "+ Arrays.toString(members));
                sc.close();
                break;
            }
        }
    }
}
