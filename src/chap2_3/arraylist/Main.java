package chap2_3.arraylist;

import chap1_8.poly.drive.Car;
import chap1_8.poly.drive.Mustang;
import chap1_8.poly.drive.Sonata;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // 문자열 전용 배열
        MyArrayList<String> foods = new MyArrayList<>();
        foods.push("볶음밥");
        foods.push("탕수육");
        foods.push("짬뽕");

        System.out.println(foods);
        // foods배열에 데이터 몇개있어요??
        int size = foods.size();
        System.out.println("size = " + size);

        // foods의 0번인덱스에 접근하고 싶어요
        String firstFood = foods.get(0);
        System.out.println("firstFood = " + firstFood);

        // 1번 인덱스 삭제
        String removed = foods.remove(1);
        System.out.println(foods);
        System.out.println("removed = " + removed);

        int index1 = foods.indexOf("짬뽕");
        System.out.println("index1 = " + index1);

        foods.clear();
        System.out.println(foods);

        System.out.println("=============");

        // 정수 전용 배열
        MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.push(100);
        numbers.push(200);
        numbers.push(300);

        numbers.remove(0);
        int index2 = numbers.indexOf(200);
        System.out.println("index2 = " + index2);

        numbers.clear();

        System.out.println("numbers = " + numbers);

        System.out.println("==========");

        // 자동차 전용 배열
        MyArrayList<Car> cars = new MyArrayList<>();
        cars.push(new Sonata());
        cars.push(new Mustang());

        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("수영");
        hobbies.add("축구");
        hobbies.add("파티");

        hobbies.clear();

        System.out.println(hobbies);

    }
}