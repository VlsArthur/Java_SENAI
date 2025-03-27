package Ativ_fix_DS_TryCatch_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ativ_05 {
    public static void main(String[] args) {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        Integer[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Choose a month: ");
            for (int i = 0; i < 12; i++) {
                System.out.println(((i<10) ? "0":"")+i+") "+months[i]);
            }
            System.out.println("---------------------------");
            System.out.print("R: ");
            Integer opt = sc.nextInt();
            System.out.println("There are " + days[opt] + " days in " + months[opt] + ".");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid choice.");
        }
    }
}
