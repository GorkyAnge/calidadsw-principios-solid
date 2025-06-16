package isp;

import isp.interfaces.Rechargeable;
import isp.interfaces.Switchable;
import isp.objects.DisposableCamera;
import isp.objects.Phone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Switchable phone = new Phone();
        Switchable camera = new DisposableCamera();

        phone.turnOn();
        ((Rechargeable) phone).charge();

        camera.turnOn();
    }
}