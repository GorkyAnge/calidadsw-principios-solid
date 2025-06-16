package ocp.Classes;

import ocp.Interfaces.Notification;

public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}