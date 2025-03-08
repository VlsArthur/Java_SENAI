package Ativ_DS_EAD_01.Exemplo_01.Application;

import Ativ_DS_EAD_01.Exemplo_01.Entities.Car;
import Ativ_DS_EAD_01.Exemplo_01.Entities.Motorcycle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Passat");
        Motorcycle motorcycle = new Motorcycle("CG 160");

        car.accelerate();
        motorcycle.accelerate();
    }
}
