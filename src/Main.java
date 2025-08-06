public class Main {
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();

        User[] users = {
                new User(queue, "사용자 1"),
                new User(queue, "사용자 2"),
                new User(queue, "사용자 3"),
                new User(queue, "사용자 4"),
                new User(queue, "사용자 5"),
        };

        for (User user: users) {
            user.start();
        }
    }
}