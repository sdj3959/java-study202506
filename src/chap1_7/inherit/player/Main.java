package chap1_7.inherit.player;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("주차왕파킹");
        Mage mage = new Mage("충격왕쇼킹");
        Hunter hunter = new Hunter("스티븐호킹");

        warrior.showStatus();
        warrior.attack();
        System.out.println("==============");

        mage.showStatus();
        mage.attack();
        System.out.println("==============");

        hunter.showStatus();
        hunter.attack();

        System.out.println("==============");

        mage.fireBall(warrior);
        mage.fireBall(hunter);
        mage.fireBall(new Mage("법사짱킹킹맨"));
    }
}
