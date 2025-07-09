package chap2_8.stream;

import java.util.Objects;

public class SimpleDish {

    private String menuName;
    private int calories;

    public SimpleDish(Dish menu) {
        this.menuName = menu.getName();
        this.calories = menu.getCalories();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SimpleDish that = (SimpleDish) o;
        return calories == that.calories && Objects.equals(menuName, that.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName, calories);
    }

    @Override
    public String toString() {
        return "{" +
                "menuName: '" + menuName + '\'' +
                ", calories: " + calories +
                '}';
    }
}
