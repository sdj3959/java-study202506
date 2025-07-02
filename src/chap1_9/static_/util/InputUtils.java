package chap1_9.static_.util;

import java.util.Scanner;

import static java.lang.System.*;

public class InputUtils {

    private static Scanner sc = new Scanner(in);

    // 입력을 받아서 메세지 출력과 함께 입력값을 리턴하는 메서드
    public static String prompt(String message) {
        out.print(message);
        return sc.nextLine();
    }
}
