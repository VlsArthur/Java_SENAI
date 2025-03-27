package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_03 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Type the radicand: ");
            Double radicand = sc.nextDouble();
            if (radicand<0) throw new ArithmeticException();
            Double root = Math.sqrt(radicand);
            System.out.println();
            System.out.println("The square root of " + radicand + " is equals to: " + root);
        } catch (ArithmeticException e) {
            System.out.println("The inserted number has no real root.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        }
    }
}
