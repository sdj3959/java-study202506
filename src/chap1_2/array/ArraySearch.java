package chap1_2.array;

// 배열 탐색 : 선형(순차) 탐색
public class ArraySearch {
    public static void main(String[] args) {
        // 배열의 인덱스 탐색과 요소 유무 확인
        String[] foods = {"족발", "파스타", "치킨", "삼겹살"};

        String target = "양념치킨";

        // 선형탐색 : 0번부터 일일이 순차적으로 체크
        int index = -1;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(target)) {
                index = i;
                break;
            }
        }
        // 유무확인
        boolean isPresent = index != -1;

        System.out.println("타겟의 인덱스: "+ index);
        System.out.println("타겟의 유무: "+ isPresent);

    }
}
