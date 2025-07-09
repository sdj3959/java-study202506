package chap2_8.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("홍길동", 15, 79));
        studentList.add(new Student("오로라핑", 18, 98));
        studentList.add(new Student("대길이", 30, 40));
        studentList.add(new Student("춘식이", 7, 20));

        // 이 리스트를 나이순으로 오름차 정렬 (나이 적은 순서)
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        studentList.forEach(System.out::println);

        System.out.println("========================================");

        // 성적 오름차 정렬
//        studentList.sort(Comparator.comparing(Student::getScore));
        // 성적 내림차 정렬
        studentList.sort(Comparator.comparing(Student::getScore).reversed());

        studentList.forEach(System.out::println);

        // 이름 오름차 정렬
        studentList.sort(Comparator.comparing(Student::getName).reversed());
        studentList.forEach(System.out::println);
    }
}
