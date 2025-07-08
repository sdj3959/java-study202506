package chap2_5.fileio.bytestream;

import chap2_5.fileio.FileExample;

import java.io.FileInputStream;

public class FileInputExample {
    public static void main(String[] args) {

        try {
            FileInputStream fis
                    = new FileInputStream(FileExample.ROOT_PATH + "/pet.txt");

            int data = 0;
            while ((data = fis.read()) != -1) {
                System.out.write(data); // 숫자를 아스키로 변환해서 출력
            }
            // 출력 버퍼 비우기
            System.out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
