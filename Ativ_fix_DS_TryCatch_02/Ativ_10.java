package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_10 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Type a integer number: ");
            Integer num = sc.nextInt();
            if (num<0) throw new NegativeNumberException();
            if (num>20) throw new ExceededFactorialLimitException();
            System.out.println(num+"! = " + factorial(num));
        } catch (NegativeNumberException e) {
            System.out.println("There are no factorial for negative numbers.");
        } catch (ExceededFactorialLimitException e) {
            System.out.println("Number greater than 20 aren't allowed.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        }

    }

    static Integer factorial(Integer num) {
        if (num == 0) {
            return 1;
        }else{
            return num*factorial(num-1);
        }
    }

    static class NegativeNumberException extends Exception {
        public NegativeNumberException() {
        }
    }

    static class ExceededFactorialLimitException extends Exception {
        public ExceededFactorialLimitException() {
        }
    }
}
