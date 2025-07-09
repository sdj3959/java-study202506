package chap2_8.stream;

import java.util.Comparator;
import java.util.List;

import static chap2_8.stream.Menu.menuList;
import static java.util.stream.Collectors.toList;

public class Sorting {
    public static void main(String[] args) {

        // 육류 요리중 칼로리가 낮은 순으로 정렬하기
        List<Dish> lowCaloriesMeats = menuList.stream()
                .filter(menu -> menu.getType() == DishType.MEAT)
                .sorted(Comparator.comparing(Dish::getCalories))
                .collect(toList());

        lowCaloriesMeats.forEach(System.out::println);

        System.out.println("========================================");

        // 메뉴들을 이름 내림차로 정렬 (zyx순)
        menuList.stream()
                .sorted(Comparator.comparing(Dish::getName).reversed())
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("========================================");

        // 300 칼로리 이상인 요리 중 칼로리가 낮은 탑3 요리를 필터링
        menuList.stream()
                .filter(m-> m.getCalories()>=300)
                .sorted(Comparator.comparing(Dish::getCalories))
                .limit(3)
                .collect(toList())
                .forEach(System.out::println);
    }
}
