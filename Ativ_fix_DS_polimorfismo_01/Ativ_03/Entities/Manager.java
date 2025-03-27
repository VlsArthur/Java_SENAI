package Ativ_fix_DS_polimorfismo_01.Ativ_03.Entities;

public class Manager extends Employee {
    private Float bonus;

    public Manager(Float bonus) {
        this.bonus = bonus;
    }

    public Manager() {
    }

    public Manager(String name, Float baseWage, Float bonus) {
        super(name, baseWage);
        this.bonus = bonus;
    }

    @Override
    public Float calcWage() {
        return bonus + super.calcWage();
    }
}
