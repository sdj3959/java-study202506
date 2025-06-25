package chap1_2.method;

import java.util.Arrays;

public class MethodQuiz {
    static String[] foods = {"떡볶이", "치킨", "파스타"};

    public static void main(String[] args) {

        printFoods();

        push("라면");
        push("김치찌개");
        printFoods();

        int index = indexOf("파스타");
        System.out.println("index = " + index);

        int index2 = indexOf("라면땅");
        System.out.println("index2 = " + index2);

        pop();
        remove("치킨");
        remove(0);
        printFoods();

        boolean flag1 = include("파스타");
        System.out.println("flag1 = " + flag1);

        boolean flag2 = include("떡라면");
        System.out.println("flag2 = " + flag2);

        insert(1, "파인애플");

        printFoods();

        modify(2, "닭갈비");
        printFoods();
    } // end main

    public static void printFoods() {
        System.out.println(Arrays.toString(foods));
    }

    public static void push(String food) {
        String[] temp =  new String[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            temp[i] = foods[i];
        }
        temp[temp.length-1] = food;
        foods = temp;
        temp = null;
    }
    public static int indexOf(String food) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(food)) {
                return i;
            }
        }
        return -1;
    }
    public static void pop() {
        String[] temp = new String[foods.length - 1];
        for (int i = 0; i < foods.length-1; i++) {
            temp[i] = foods[i];
        }
        foods = temp;
        temp = null;
    }
    public static void remove(int index) {
        String[] temp = new String[foods.length - 1];
        for (int i = 0, j = 0; i < foods.length; i++) {
            if (i == index) {
                continue;
            }
            temp[j++] = foods[i];
        }
        foods = temp;
        temp = null;
    }
    public static void remove(String food) {
        String[] temp = new String[foods.length - 1];
        for (int i = 0, j = 0; i < foods.length; i++) {
            if (food.equals(foods[i])) {
                continue;
            }
            temp[j++] = foods[i];
        }
        foods = temp;
        temp = null;
    }
    public static boolean include(String food) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(food)) {
                return true;
            }
        }
        return false;
    }
    public static void insert(int index, String food) {
        String[] temp = new String[foods.length + 1];
        for (int i = 0, j=0; i < foods.length+1; i++) {
            if (i == index) {
                temp[i] = food;
                continue;
            }
            temp[i] = foods[j++];
        }
        foods = temp;
        temp = null;
    }
    public static void modify(int index, String food) {
        String[] temp = new String[foods.length];
        for (int i = 0 ; i < foods.length; i++) {
            if (i == index) {
                temp[i] = food;
                continue;
            }
            temp[i] = foods[i];
        }
        foods = temp;
        temp = null;
    }

}
