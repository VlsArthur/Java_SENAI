package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

import java.util.Scanner;

public class ativ_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerList integerList = new IntegerList();

        System.out.println("Type numbers: ");
        integerList.addNumbers(6, sc);
        double avg = integerList.avg();
        System.out.println("The average of the numbers you've inserted is equals to " + String.format("%.2f", avg) + ".");

        sc.close();
    }
}
