package chap1_8.poly.message;

public class User extends Messenger{

    public User(String name) {
        super(name);
    }

    @Override
    void sendMessage(String message) {
        System.out.println("[사용자] " + getName() + " : " + message);
    }
}
