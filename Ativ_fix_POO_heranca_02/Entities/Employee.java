package Ativ_fix_POO_heranca_02.Entities;

public class Employee extends Person {
    private int sectorCode;
    private float baseWage;
    private float tributes;

    public Employee() {
        super();
    }

    public Employee(String name, String phone, int sectorCode, float baseWage, float tributes) {
        super(name, phone);
        this.sectorCode = sectorCode;
        this.baseWage = baseWage;
        this.tributes = tributes;
    }

    public Employee(String name, String address, String phone, int sectorCode, float baseWage, float tributes) {
        super(name, address, phone);
        this.sectorCode = sectorCode;
        this.baseWage = baseWage;
        this.tributes = tributes;
    }

    public int getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(int sectorCode) {
        this.sectorCode = sectorCode;
    }

    public float getBaseWage() {
        return baseWage;
    }

    public void setBaseWage(float baseWage) {
        this.baseWage = baseWage;
    }

    public float getTributes() {
        return tributes;
    }

    public void setTributes(float tributes) {
        this.tributes = tributes;
    }

    public void finalWage() {
        float tributesValue = getBaseWage() * getTributes() / 100;
        float finalWage = getBaseWage() - tributesValue;
        System.out.println("Base wage: R$ " + String.format("%.2f", getBaseWage()));
        System.out.println("Tributes: R$ " + String.format("%.2f", tributesValue));
        System.out.println("Final wage: R$ " + String.format("%.2f", finalWage));
    }

}
