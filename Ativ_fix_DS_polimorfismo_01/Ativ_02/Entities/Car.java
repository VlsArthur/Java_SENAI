package Ativ_fix_DS_polimorfismo_01.Ativ_02.Entities;

public class Car extends Vehicle {
    public Car() {
    }

    @Override
    public void move() {
        System.out.println("The car is moving fastly.");
    }
}
