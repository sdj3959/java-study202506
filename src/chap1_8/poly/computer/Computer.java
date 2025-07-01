package chap1_8.poly.computer;

public class Computer {

    // 키보드
    // 삼성 키보드와의 결합도가 높아서 의존관계가 너무 심해짐
    // 부품객체의 유연성이 떨어진다
//    private SamsungKeyboard keyboard;
    private Keyboard keyboard;

    // 초기 키보드 세팅
    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }


    // 키보드 교환 기능
    public void changeKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
        System.out.println("키보드가 교체되었습니다.");
    }
}
