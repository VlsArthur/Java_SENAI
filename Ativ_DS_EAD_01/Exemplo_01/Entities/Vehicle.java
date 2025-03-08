package Ativ_DS_EAD_01.Exemplo_01.Entities;

abstract class Vehicle {
    private String model;


    public Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    abstract void accelerate();
}
