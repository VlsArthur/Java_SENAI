package Ativ_fix_POO_heranca_02.Entities;

public class Admin extends Employee{
    private float costAssist;

    public Admin() {
        super();
    }

    public Admin(String name, String phone, int sectorCode, float baseWage, float tributes, float costAssist) {
        super(name, phone, sectorCode, baseWage, tributes);
        this.costAssist = costAssist;
    }

    public Admin(String name, String address, String phone, int sectorCode, float baseWage, float tributes, float costAssist) {
        super(name, address, phone, sectorCode, baseWage, tributes);
        this.costAssist = costAssist;
    }

    public float getCostAssist() {
        return costAssist;
    }

    public void setCostAssist(float costAssist) {
        this.costAssist = costAssist;
    }

    @Override
    public void finalWage() {
        float tributesValue = getBaseWage() * getTributes() / 100;
        float finalWage = getBaseWage() - tributesValue + getCostAssist();
        System.out.println("Base wage: R$ " + String.format("%.2f", getBaseWage()));
        System.out.println("Tributes: R$ " + String.format("%.2f", tributesValue));
        System.out.println("Cost assistance: R$ " + String.format("%.2f", getCostAssist()));
        System.out.println("Final wage: R$ " + String.format("%.2f", finalWage));
    }
}
