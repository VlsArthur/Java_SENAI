package Ativ_fix_DS_polimorfismo_01.Ativ_03.Entities;

public class Employee {
    private String name;
    private Float baseWage;

    public Employee() {
    }

    public Employee(String name, Float baseWage) {
        this.name = name;
        this.baseWage = baseWage;
    }

    public Float calcWage() {
        return baseWage;
    }
}
