package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_06 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Type your name: ");
            String name = sc.nextLine();
            System.out.print("Type your age: ");
            Integer age = sc.nextInt();
            System.out.println();
            if (name.isEmpty() || age<0) {
                throw new InvalidDataException();
            }
        } catch (InvalidDataException e) {
            System.out.println("You've inserted invalid data.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        }

    }

    static class InvalidDataException extends Exception {
        public InvalidDataException() {
        }
    }
}
