package chap1_8.poly.message;

public class Admin extends Messenger{

    public Admin(String name) {
        super(name);
    }

    @Override
    void sendMessage(String message) {
        System.out.println("🚨[관리자] " + getName() + " : " + message+"🚨");
    }
}
