package isp.objects;

import isp.interfaces.Rechargeable;
import isp.interfaces.Switchable;

public class Phone implements Rechargeable, Switchable {
    @Override
    public void turnOn() {
        System.out.println("Phone is turning on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Phone is turning off.");
    }

    @Override
    public void charge() {
        System.out.println("Phone is charging.");
    }
}
