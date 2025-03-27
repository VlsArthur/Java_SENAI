package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_04 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Type the 1st addend: ");
            Double num1 = sc.nextDouble();
            System.out.print("Type the 2nd addend: ");
            Double num2 = sc.nextDouble();
            System.out.println();
            Double sum = num1 + num2;
            System.out.println();
            System.out.println(num1 + " + " + num2 + " = " + sum);
        } catch (InputMismatchException e) {
            System.out.println("Only numbers are accepted as input.");
        }
    }
}
