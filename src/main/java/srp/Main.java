package srp;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager(
                new UserValidator(),
                new UserRepository(),
                new NotificationService()
        );

        userManager.addUser("example@domain.com", "password123");
        userManager.addUser("invalid-email", "1234");
    }
}
