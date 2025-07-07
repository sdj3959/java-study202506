package chap2_4.collection.set;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {

        /*
            Set (집합)
            1. 중복을 허용하지 않는다.
            2. 순서를 보장하지 않는다. (해시)
         */

        Set<String> set = new HashSet<>();

        set.add("떡볶이");
        set.add("김말이");
        boolean flag1 = set.add("김밥");
        set.add("단무지");
        boolean flag2 = set.add("김밥");

        System.out.println(set);
        System.out.println("flag1 = " + flag1);
        System.out.println("flag2 = " + flag2);
        System.out.println(set.size());

        // 요소 삭제: set은 순서가 없기 때문에 인덱스도 없음
        set.remove("단무지");
        System.out.println(set);

        for (String s : set) {
            System.out.println("s = " + s);
        }

        // 실무에서 set의 용도는 리스트같은 자료구조의 중복제거 용도
        List<Integer> numbers = List.of(3, 3, 3, 1, 1, 1, 3, 3, 3, 5, 5, 5, 7, 7, 7, 7, 2, 5, 2, 2, 1);
        System.out.println(numbers);

        // set으로 변환
        HashSet<Integer> numSet = new HashSet<>(numbers);
        System.out.println(numSet);
        
        // list로 다시 변환
        numbers = new ArrayList<>(numSet);
        System.out.println("numbers = " + numbers);

        // equals와 hashcode를 오버라이딩 하는 이유
        System.out.println("======================");
        Person p1 = new Person("김철수", "850516");
        Person p2 = new Person("박영희", "780911");
        Person p3 = new Person("김철수", "850516");

        Set<Person> personSet = new HashSet<>();
        personSet.add(p1);
        personSet.add(p2);
        personSet.add(p3);

        System.out.println(personSet);
        System.out.println("p1 == p3 ? " + (p1.equals(p3)));
    }
}

class Person {
    String name;
    String ssn;

    public Person(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(ssn, person.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ssn);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
