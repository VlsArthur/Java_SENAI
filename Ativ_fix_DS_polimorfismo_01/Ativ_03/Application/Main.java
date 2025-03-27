package Ativ_fix_DS_polimorfismo_01.Ativ_03.Application;

import Ativ_fix_DS_polimorfismo_01.Ativ_03.Entities.Developer;
import Ativ_fix_DS_polimorfismo_01.Ativ_03.Entities.Employee;
import Ativ_fix_DS_polimorfismo_01.Ativ_03.Entities.Manager;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Matthew", 1400.12f);
        Manager manager =  new Manager("Kenia", 1630.70f, 600f);
        Developer developer =  new Developer("Ian", 1630.70f);

        System.out.printf("Employee wage: %.2f\n", employee.calcWage());
        System.out.printf("Manager wage: %.2f\n", manager.calcWage());
        System.out.printf("Developer wage: %.2f\n", developer.calcWage());
    }
}
