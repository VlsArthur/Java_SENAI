package Ativ_fix_DS_polimorfismo_01.Ativ_01.Application;

import Ativ_fix_DS_polimorfismo_01.Ativ_01.Entities.Animal;
import Ativ_fix_DS_polimorfismo_01.Ativ_01.Entities.Dog;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();

        animal.sound();
        dog.sound();
    }
}
