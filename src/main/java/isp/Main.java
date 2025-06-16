package isp;

import isp.interfaces.Device;
import isp.objects.DisposableCamera;
import isp.objects.Phone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Device phone = new Phone();
        Device camera = new DisposableCamera();

        phone.turnOn();
        phone.charge();

        camera.turnOn();
        camera.charge(); // Excepción: UnsupportedOperationException
    }
}