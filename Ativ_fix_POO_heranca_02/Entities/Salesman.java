package Ativ_fix_POO_heranca_02.Entities;

public class Salesman extends Employee {
    private float salesValue;
    private float commissionPct;

    public Salesman() {
        super();
    }

    public Salesman(String name, String phone, int sectorCode, float baseWage, float tributes, float salesValue, float commissionPct) {
        super(name, phone, sectorCode, baseWage, tributes);
        this.salesValue = salesValue;
        this.commissionPct = commissionPct;
    }

    public Salesman(String name, String address, String phone, int sectorCode, float baseWage, float tributes, float salesValue, float commissionPct) {
        super(name, address, phone, sectorCode, baseWage, tributes);
        this.salesValue = salesValue;
        this.commissionPct = commissionPct;
    }

    public float getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(float salesValue) {
        this.salesValue = salesValue;
    }

    public float getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(float commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Override
    public void finalWage() {
        float tributesValue = getBaseWage() * getTributes() / 100;
        float commissionValue = getSalesValue() * getCommissionPct() / 100;
        float finalWage = getBaseWage() - tributesValue + commissionValue;
        System.out.println("Base wage: R$ " + String.format("%.2f", getBaseWage()));
        System.out.println("Tributes: R$ " + String.format("%.2f", tributesValue));
        System.out.println("Commission: R$ " + String.format("%.2f", commissionValue));
        System.out.println("Final wage: R$ " + String.format("%.2f", finalWage));
    }
}
