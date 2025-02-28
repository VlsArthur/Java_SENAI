package Ativ_fix_POO_heranca_02.Application;

import Ativ_fix_POO_heranca_02.Entities.*;

public class App {
    public static void main(String[] args) {
        // Supplier test
        Supplier supplier = new Supplier("Ambev", "Av. Helena de Vasconcelos Costa, 750 - Cincao, Contagem - MG, 32371-685", "0800 887 1111", 50000, 55000);
        System.out.println(supplier);
        supplier.balance();

        System.out.println();

        // Employee test
        Employee employee = new Employee("Cauã", "R. dos bobos, 0", "31 9 9435-1887", 0, 1412, 4);
        employee.finalWage();

        System.out.println();

        // Admin test
        Admin admin = new Admin("Cauã", "R. dos bobos, 0", "31 9 9435-1887", 1, 2112, 10, 520);
        admin.finalWage();

        System.out.println();

        // Worker Test
        Worker worker = new Worker("Ian", "R. dos bobos, 0", "31 9 8989-7144", 2, 1856, 6, 25000, 1);
        admin.finalWage();

        System.out.println();

        // Salesman Test
        Salesman salesman = new Salesman("Matheus", "R. dos bobos, 0", "31 9 9602-3722", 3, 1412, 4, 18000, 1);
        admin.finalWage();
    }
}
