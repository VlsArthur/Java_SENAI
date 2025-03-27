package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_02 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Type a number: ");
            Double num = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        }
    }
}
