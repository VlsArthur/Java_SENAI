package Ativ_fix_POO_heranca_01.Ativ_02.Entities;

public class Salesman extends Employee {
    private float commissionPct;
    private float finalWage;

    public Salesman() {
        super();
    }

    public Salesman(String name, float wage, float commissionPct) {
        super(name, wage);
        this.commissionPct = commissionPct;
    }

    public float getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(float commissionPct) {
        this.commissionPct = commissionPct;
    }

    public float getFinalWage() {
        return finalWage;
    }

    public void setFinalWage(float finalWage) {
        this.finalWage = finalWage;
    }

    public float calcFinalWage(float sales) {
        return getWage() + ((sales * getCommissionPct()) / 100);
    }

    @Override
    public String toString() {
        return "------ Salesman ------" + '\n' +
                "Name: " + getName() + '\n' +
                "Base wage: R$ " + String.format("%.2f", getWage()) + '\n' +
                "Commissions: R$ " + String.format("%.2f", (getFinalWage() - getWage())) + '\n' +
                "Final wage: R$ " + String.format("%.2f", getFinalWage()) + '\n' +
                "----------------------";
    }
}
