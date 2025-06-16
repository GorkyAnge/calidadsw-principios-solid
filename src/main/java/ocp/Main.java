package ocp;

import ocp.Classes.EmailNotification;
import ocp.Classes.PushNotification;
import ocp.Classes.SMSNotification;
import ocp.Services.NotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.sendNotification(new EmailNotification(), "Hello via Email!");
        service.sendNotification(new SMSNotification(), "Hello via SMS!");
        service.sendNotification(new PushNotification(), "Hello via Push Notification!");

    }
}