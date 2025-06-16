package isp.objects;

import isp.interfaces.Switchable;

public class DisposableCamera implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Disposable camera is turning on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Disposable camera is turning off.");
    }
}
