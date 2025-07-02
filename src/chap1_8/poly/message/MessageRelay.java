package chap1_8.poly.message;

public class MessageRelay {
    public void relay(Messenger sender, String message) {
        if (sender instanceof Admin) {
            sender.sendMessage(message);
        } else if (sender instanceof User) {
            sender.sendMessage(message);
        }
    }
}
