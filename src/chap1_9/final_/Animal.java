package chap1_9.final_;

class Cat extends Animal {

//    @Override
//    public void eat() {
//        System.out.println("생선을 얌냠냠");
//    }
}

// final class: 상속 금지
public class Animal {

    // final method: 오버라이딩 금지
    public final void eat() {
        System.out.println("밥을 얌냠냠~");
    }
    public void makeSound() {}
}
