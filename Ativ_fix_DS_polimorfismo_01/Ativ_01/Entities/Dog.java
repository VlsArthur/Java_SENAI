package Ativ_fix_DS_polimorfismo_01.Ativ_01.Entities;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("The dog barks.");
    }
}
