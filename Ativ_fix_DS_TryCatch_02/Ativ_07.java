package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_07 {
    public static void main(String[] args) throws InvalidScoreException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Type the 1st test score: ");
            Double s1 = sc.nextDouble();
            verifyScore(s1);
            System.out.print("Type the 2nd test score: ");
            Double s2 = sc.nextDouble();
            verifyScore(s2);
            System.out.print("Type the 3rd test score: ");
            Double s3 = sc.nextDouble();
            verifyScore(s3);
            System.out.println();
            Double avg = (s1+s2+s3)/3;
            System.out.println("The student sverage is: " + avg);
        } catch (InputMismatchException e) {
            System.out.println("Only integer numbers are accepted as input.");
        } catch (InvalidScoreException e) {
            System.out.println("Negative scores are not allowed.");
        }
    }
    static void verifyScore(Double score) throws InvalidScoreException {
        if (score<0) {
            throw new InvalidScoreException();
        }
    }
    static class InvalidScoreException extends Exception {
        public InvalidScoreException() {
        }
    }
}
