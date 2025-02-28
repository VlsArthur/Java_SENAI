package Ativ_fix_POO_heranca_01.Ativ_02.Entities;

public class Manager extends Employee {
    private String department;

    public Manager() {
        super();
    }

    public Manager(String name, float wage, String department) {
        super(name, wage);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "------ Employee ------" + '\n' +
                "Name: " + getName() + '\n' +
                "Wage: R$ " + String.format("%.2f", getWage()) + '\n' +
                "Department: " + getDepartment() + '\n' +
                "----------------------";
    }
}
