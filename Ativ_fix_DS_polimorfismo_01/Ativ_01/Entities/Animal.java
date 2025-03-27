package Ativ_fix_DS_polimorfismo_01.Ativ_01.Entities;

public class Animal {
    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println("Animal generic sound.");
    }
}
