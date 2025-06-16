# Reflexión sobre el Principio Abierto/Cerrado (OCP)

## Contexto del Problema

El proyecto inicial presentaba una violación clara del Principio Abierto/Cerrado (OCP) en la clase `NotificationService`. Esta clase era responsable de enviar diferentes tipos de notificaciones (Correo Electrónico, SMS, Push) y utilizaba una estructura condicional (`if-else if`) para determinar la lógica de envío basada en el tipo de notificación recibido.

El problema fundamental de este diseño era que cada vez que se necesitaba añadir un nuevo tipo de notificación (por ejemplo, Fax o notificaciones por una nueva aplicación), se hacía indispensable modificar directamente el código fuente de `NotificationService`. Esta práctica generaba un código rígido y frágil, altamente propenso a errores, especialmente a medida que la aplicación crecía y se añadían más funcionalidades, incrementando la dificultad de mantenimiento.

## Aplicación del Principio Abierto/Cerrado (OCP)

Para solucionar esta problemática y adherirse al OCP, se llevó a cabo una refactorización estratégica:

1.  **Definición de una Interfaz Común (`Notification`)**: Se creó una interfaz `Notification` que declara un método `send(String message)`. Esta interfaz actúa como un contrato que todas las implementaciones de notificación deben seguir, estableciendo una abstracción para el proceso de envío.

2.  **Creación de Clases de Notificación Específicas**: Se implementaron clases concretas para cada tipo de notificación existente: `EmailNotification`, `SMSNotification` y `PushNotification`. Cada una de estas clases implementa la interfaz `Notification` y contiene la lógica específica para enviar su respectivo tipo de mensaje. Esto encapsula la funcionalidad de envío dentro de sus propias clases, haciendo que cada una sea responsable de su tipo de notificación.

3.  **Refactorización de `NotificationService`**: La clase `NotificationService` fue modificada para depender de la interfaz `Notification` en lugar de las implementaciones concretas. Ahora, su método `sendNotification` acepta un objeto de tipo `Notification` y delega la responsabilidad de envío a este objeto, utilizando polimorfismo.

```java
// Interfaz para métodos de notificación
interface Notification {
    void send(String message);
}

// Implementaciones de métodos de notificación
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

// Clase NotificationService que delega el proceso a las implementaciones
class NotificationService {
    public void sendNotification(Notification notification, String message) {
        notification.send(message);
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        // Procesar diferentes métodos de notificación
        service.sendNotification(new EmailNotification(), "Hello via Email!");
        service.sendNotification(new SMSNotification(), "Hello via SMS!");
        service.sendNotification(new PushNotification(), "Hello via Push Notification!");

        // Si se añade un nuevo tipo de notificación (ej. FaxNotification), no se modifica NotificationService
        // class FaxNotification implements Notification {
        //     @Override
        //     public void send(String message) {
        //         System.out.println("Sending Fax: " + message);
        //     }
        // }
        // service.sendNotification(new FaxNotification(), "Hello via Fax!");
    }
}
```


# Reflexión sobre el Principio de Inversión de Dependencias (DIP)

## Contexto del Problema

En la implementación original del módulo de pagos, la clase `PaymentProcessor` dependía directamente de la clase concreta `CreditCardPayment`. Esto generaba un acoplamiento fuerte, dificultando la extensión del sistema para soportar nuevos métodos de pago como PayPal o Crypto, ya que cualquier cambio requería modificar la lógica interna de `PaymentProcessor`. Esta situación violaba el Principio de Inversión de Dependencias (DIP) y el Principio Abierto/Cerrado (OCP).

## Aplicación del DIP

Para resolver este problema, se refactorizó el código de la siguiente manera:

- Se creó la interfaz `PaymentMethod`, que define el contrato para cualquier método de pago.
- Se implementaron las clases concretas `CreditCardPayment`, `PayPalPayment` y `CryptoPayment`, cada una siguiendo la interfaz `PaymentMethod`.
- `PaymentProcessor` ahora depende de la abstracción `PaymentMethod` y recibe la implementación concreta mediante inyección de dependencias (por el constructor).

## Beneficios Obtenidos

- **Desacoplamiento:** Ahora `PaymentProcessor` no necesita conocer los detalles de cada método de pago, solo interactúa con la interfaz.
- **Extensibilidad:** Es posible agregar nuevos métodos de pago sin modificar el código existente de `PaymentProcessor`, cumpliendo con el OCP.
- **Mantenibilidad:** El código es más limpio, modular y fácil de mantener o probar.

## Ejemplo de Uso

```java
PaymentMethod creditCard = new CreditCardPayment();
PaymentMethod paypal = new PayPalPayment();
PaymentMethod crypto = new CryptoPayment();

PaymentProcessor processor1 = new PaymentProcessor(creditCard);
processor1.makePayment(150.0);

PaymentProcessor processor2 = new PaymentProcessor(paypal);
processor2.makePayment(200.0);

PaymentProcessor processor3 = new PaymentProcessor(crypto);
processor3.makePayment(300.0);
```

Con esta refactorización, el sistema de pagos es flexible y preparado para el crecimiento futuro, alineándose con los principios SOLID.
