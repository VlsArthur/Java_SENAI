package Ativ_fix_POO_heranca_01.Ativ_03.Entities;

public class Fish extends Animal {
    private String characteristics;

    public Fish() {
        super();
    }

    public Fish(String name, float length, int pawCount, String color, String habitat, float avgSpeed, String characteristics) {
        super(name, length, pawCount, color, habitat, avgSpeed);
        this.characteristics = characteristics;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public void fishData() {
        String characteristics = getCharacteristics();
        data();
        System.out.println("Characteristics: " + characteristics);
    }

}
