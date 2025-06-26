package chap1_3;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle grandeur = new Vehicle("현대", "그랜져");
        Vehicle panamera = new Vehicle("포르쉐", "파나메라");

        grandeur.powerOn();

        System.out.println("grandeur = " + grandeur);
        System.out.println("panamera = " + panamera);
    }
}
