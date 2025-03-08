package Ativ_DS_EAD_01.Exemplo_01.Entities;

public class Car extends Vehicle {

    public Car(String model) {
        super(model);
    }

    public void accelerate() {
        System.out.println("The " + getModel() + " car is accelerating!");
    }
}
