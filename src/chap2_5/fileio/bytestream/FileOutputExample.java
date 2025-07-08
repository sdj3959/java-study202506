package chap2_5.fileio.bytestream;

import chap2_5.fileio.FileExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputExample {
    public static void main(String[] args) {

        // 바이트 기반 출력 스트림 - 1바이트 단위로 데이터 처리
        // 주로 이미지, 영상같은 바이너리 데이터 처리에 적합
        try {
            FileOutputStream fos
                    = new FileOutputStream(FileExample.ROOT_PATH + "/pet.txt");

//            String str = "dog";
            fos.write(new byte[] {99,97,116});

        } catch (FileNotFoundException e) {
            File rootDirectory = new File(FileExample.ROOT_PATH);
            if (!rootDirectory.exists()) rootDirectory.mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
