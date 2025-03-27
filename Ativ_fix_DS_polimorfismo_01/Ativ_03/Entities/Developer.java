package Ativ_fix_DS_polimorfismo_01.Ativ_03.Entities;

public class Developer extends Employee {
    private final Float additionalPct = 0.10f;

    public Developer() {
    }

    public Developer(String name, Float baseWage) {
        super(name, baseWage);
    }

    @Override
    public Float calcWage() {
        return super.calcWage() + (super.calcWage() * additionalPct);
    }
}
