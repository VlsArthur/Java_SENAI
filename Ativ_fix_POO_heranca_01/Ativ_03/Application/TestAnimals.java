package Ativ_fix_POO_heranca_01.Ativ_03.Application;

import Ativ_fix_POO_heranca_01.Ativ_03.Entities.Animal;
import Ativ_fix_POO_heranca_01.Ativ_03.Entities.Fish;
import Ativ_fix_POO_heranca_01.Ativ_03.Entities.Mammal;

public class TestAnimals {
    public static void main(String[] args) {
        Animal camel = new Animal ("Camel", 150, 4, "Yellow", "Land", 2f);
        Fish shark = new Fish("Shark", 300, 0, "Gray", "Aquatic", 1.5f, "Fin and tail");
        Mammal canadianBear = new Mammal("Canadian bear", 180, 4, "Red", "Land", 0.5f, "Honey");

        camel.data();
        System.out.println();
        shark.fishData();
        System.out.println();
        canadianBear.mammalData();
    }
}
