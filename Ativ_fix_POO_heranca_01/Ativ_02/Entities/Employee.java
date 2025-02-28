package Ativ_fix_POO_heranca_01.Ativ_02.Entities;

public class Employee {
    private String name;
    protected float wage;

    public Employee() {
    }

    public Employee(String name, float wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "------ Employee ------" + '\n' +
                "Name:'" + getName() + '\n' +
                "Wage: R$ " + String.format("%.2f", getWage()) + '\n' +
                "----------------------";
    }
}
