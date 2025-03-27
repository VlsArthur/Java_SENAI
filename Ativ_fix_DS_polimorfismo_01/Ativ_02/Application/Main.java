package Ativ_fix_DS_polimorfismo_01.Ativ_02.Application;

import Ativ_fix_DS_polimorfismo_01.Ativ_02.Entities.Bike;
import Ativ_fix_DS_polimorfismo_01.Ativ_02.Entities.Car;
import Ativ_fix_DS_polimorfismo_01.Ativ_02.Entities.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Car(), new Bike()};

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
