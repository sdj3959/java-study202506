package chap1_8.poly.casting;

import chap1_8.poly.drive.Sonata;

// 운전자 (운전 직원)
public class Driver {

    String name;

    public Driver(String name) {
        this.name = name;
    }

    public void drive(Sonata car) {
        System.out.printf("%s님이 운전을 시작합니다.\n", this.name);
        car.accelerate();
    }
}
