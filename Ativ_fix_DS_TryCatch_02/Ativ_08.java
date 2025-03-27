package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_08 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Type your age: ");
            Integer age = sc.nextInt();
            System.out.println();
            verifyAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("You've inserted invalid age.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        }

    }

    static void verifyAge(Integer age) throws InvalidAgeException {
        if (age < 0) throw new InvalidAgeException();
        if (age < 18) System.out.println("You a minor.");
        if (age >= 18) System.out.println("You an adult.");
    }
    static class InvalidAgeException extends Exception {
        public InvalidAgeException() {
        }
    }
}
