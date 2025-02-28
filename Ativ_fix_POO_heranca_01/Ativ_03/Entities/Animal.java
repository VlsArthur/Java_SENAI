package Ativ_fix_POO_heranca_01.Ativ_03.Entities;

public class Animal {
    private String name;
    private float length;
    private int pawCount;
    private String color;
    private String habitat;
    private float avgSpeed;

    public Animal() {
    }

    public Animal(String name, float length, int pawCount, String color, String habitat, float avgSpeed) {
        this.name = name;
        this.length = length;
        this.pawCount = pawCount;
        this.color = color;
        this.habitat = habitat;
        this.avgSpeed = avgSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getPawCount() {
        return pawCount;
    }

    public void setPawCount(int pawCount) {
        this.pawCount = pawCount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public float getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(float avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public void data() {
        String name = getName();
        float length = getLength();
        int pawCount = getPawCount();
        String color = getColor();
        String habitat = getHabitat();
        float avgSpeed = getAvgSpeed();
        System.out.println("Animal name: " + name);
        System.out.println("Length: " + length);
        System.out.println("Paw count: " + pawCount);
        System.out.println("Color: " + color);
        System.out.println("Habitat: " + habitat);
        System.out.println("Average speed: " + avgSpeed + "m/s");
    }
}
