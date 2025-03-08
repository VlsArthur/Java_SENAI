package Ativ_DS_EAD_01.Exemplo_02.Application;

import Ativ_DS_EAD_01.Exemplo_02.Entities.Calc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insert the loan value: R$");
        double principal = sc.nextDouble();
        System.out.print("Insert how many monthly installments you want to pay in: ");
        int time = sc.nextInt();

        double interest = Calc.Finantial.calcSimpleInterest(principal, 1.5, time);
        double total = principal + interest;
        double installment = total / time;

        System.out.println();
        System.out.println("Loan value: R$" + String.format("%.2f", principal));
        System.out.println("Interest value: R$" + String.format("%.2f", interest));
        System.out.println("*Total: R$" + String.format("%.2f", total));
        System.out.println("*Monthly installment value: R$" + String.format("%.2f", installment));

        double dollarTotal = Calc.Finantial.convertCurrency(total, 0.1727) * 0.95;
        double dollarInstallment = dollarTotal / time;

        System.out.println();
        System.out.println("*: You can still pay it in dollar currency for a ~5% discount (U$" +
                String.format("%.2f", dollarTotal) +
                " in " + time + "x installments of U$" +
                String.format("%.2f", dollarInstallment) +
                ")"
        );
    }
}
