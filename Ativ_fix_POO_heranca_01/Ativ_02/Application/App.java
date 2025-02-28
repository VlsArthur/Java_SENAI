package Ativ_fix_POO_heranca_01.Ativ_02.Application;

import Ativ_fix_POO_heranca_01.Ativ_02.Entities.Manager;
import Ativ_fix_POO_heranca_01.Ativ_02.Entities.Salesman;

public class App {
    public static void main(String[] args) {
        Manager manager = new Manager("Larissa", 2118, "Sales");
        System.out.println(manager);
        System.out.println();
        Salesman salesman = new Salesman("Emanuel", 1412, 1);
        float finalWage = salesman.calcFinalWage(24000);
        salesman.setFinalWage(finalWage);
        System.out.println(salesman);
    }
}
