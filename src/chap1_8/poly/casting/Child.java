package chap1_8.poly.casting;

public class Child extends Parent {
    int c1;

    @Override
    void parentMethod() {
        System.out.println("Overriding한 child의 메서드 1 !!");
    }

    void childMethod() {
        System.out.println("Child가 단독으로 만든 메서드 2 !!");
    }
}
