package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_01 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Type the dividend: ");
            Integer dividend = sc.nextInt();
            System.out.print("Type the divisor: ");
            Integer divisor = sc.nextInt();
            System.out.println();
            Double quotient = (double) (dividend / divisor);
            System.out.println(dividend + " / " + divisor + " = " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("You can't divide a number by 0.");
        } catch (InputMismatchException e) {
            System.out.println("Only integer numbers are accepted as input.");
        }
    }
}
