package lsp;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal fish = new Fish();

        dog.makeSound();
        if (dog instanceof Walkable) {
            ((Walkable) dog).walk();
        }

        fish.makeSound();
        // No intenta caminar con fish, evitando error
    }
}
