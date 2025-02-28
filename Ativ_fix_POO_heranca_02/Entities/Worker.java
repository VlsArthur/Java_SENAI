package Ativ_fix_POO_heranca_02.Entities;

public class Worker extends Employee {
    private float productionValue;
    private float commissionPct;

    public Worker() {
        super();
    }

    public Worker(String name, String phone, int sectorCode, float baseWage, float tributes, float productionValue, float commissionPct) {
        super(name, phone, sectorCode, baseWage, tributes);
        this.productionValue = productionValue;
        this.commissionPct = commissionPct;
    }

    public Worker(String name, String address, String phone, int sectorCode, float baseWage, float tributes, float productionValue, float commissionPct) {
        super(name, address, phone, sectorCode, baseWage, tributes);
        this.productionValue = productionValue;
        this.commissionPct = commissionPct;
    }

    public float getProductionValue() {
        return productionValue;
    }

    public void setProductionValue(float productionValue) {
        this.productionValue = productionValue;
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
        float commissionValue = getProductionValue() * getCommissionPct() / 100;
        float finalWage = getBaseWage() - tributesValue + commissionValue;
        System.out.println("Base wage: R$ " + String.format("%.2f", getBaseWage()));
        System.out.println("Tributes: R$ " + String.format("%.2f", tributesValue));
        System.out.println("Commission: R$ " + String.format("%.2f", commissionValue));
        System.out.println("Final wage: R$ " + String.format("%.2f", finalWage));
    }
}
