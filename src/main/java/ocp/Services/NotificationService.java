package ocp.Services;

import ocp.Interfaces.Notification;

public class NotificationService {
    public void sendNotification(Notification notification, String message) {
        notification.send(message);
    }
}