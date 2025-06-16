package lsp;

// Soundable.java
public interface Soundable {
    void makeSound();
}

// Walkable.java
public interface Walkable {
    void walk();
}

// Dog.java
public class Dog implements Soundable, Walkable {
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }

    @Override
    public void walk() {
        System.out.println("Dog is walking.");
    }
}

// Fish.java
public class Fish implements Soundable {
    @Override
    public void makeSound() {
        System.out.println("Fish makes bubbly sounds.");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Soundable dog = new Dog();
        Soundable fish = new Fish();

        System.out.println("Testing Dog:");
        dog.makeSound();
        if (dog instanceof Walkable) {
            ((Walkable) dog).walk();
        }

        System.out.println("\nTesting Fish:");
        fish.makeSound();
        if (fish instanceof Walkable) {
            ((Walkable) fish).walk(); // Esto no se ejecuta
        }
    }
}
