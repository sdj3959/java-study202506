package chap1_3.arraylist;

public class ListMain {
    public static void main(String[] args) {
        StringList foods = new StringList();
        StringList userNames = new StringList();

        foods.push("짜장면","짬뽕", "닭곰탕");
        String delete = foods.pop();

        userNames.push("김철수","하츄핑");
        System.out.println(userNames);

        System.out.println(foods);
        System.out.println("delete = " + delete);
    }
}
