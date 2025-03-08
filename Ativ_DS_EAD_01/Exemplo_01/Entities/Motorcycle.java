package Ativ_DS_EAD_01.Exemplo_01.Entities;

public class Motorcycle extends Vehicle {

    public Motorcycle(String model) {
        super(model);
    }

    public void accelerate() {
        System.out.println("The " + getModel() + " motorcycle is accelerating!");
    }
}
