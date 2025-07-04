package chap2_2.lang;

class Pen {
    long serial; // 일련번호
    String color; // 색상
    int price; // 가격

    public Pen(long serial, String color, int price) {
        this.serial = serial;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof Pen) {
            Pen target = (Pen) obj;
            if (
                    this.serial == target.serial
                            && this.color.equals(target.color)
            ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "serial=" + serial +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

public class ObjectSample {

    public static void main(String[] args) {

        Pen yellowPen = new Pen(100L, "노랑", 1000);
        Pen bluePen = new Pen(200L, "파랑", 1200);
        Pen bluePen2 = new Pen(200L, "파랑", 1200);

        System.out.println(yellowPen);
        System.out.println(bluePen);

        System.out.println("두 펜이 같은가? " + (bluePen.equals(bluePen2)));

    }
}
