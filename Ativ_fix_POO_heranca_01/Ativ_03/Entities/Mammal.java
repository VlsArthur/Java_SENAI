package Ativ_fix_POO_heranca_01.Ativ_03.Entities;

public class Mammal extends Animal {
    private String feeding;

    public Mammal() {
        super();
    }

    public Mammal(String name, float length, int pawCount, String color, String habitat, float avgSpeed, String feeding) {
        super(name, length, pawCount, color, habitat, avgSpeed);
        this.feeding = feeding;
    }

    public String getFeeding() {
        return feeding;
    }

    public void setFeeding(String feeding) {
        this.feeding = feeding;
    }

    public void mammalData() {
        String feeding = getFeeding();
        data();
        System.out.println("Feeding: " + feeding);
    }
}
