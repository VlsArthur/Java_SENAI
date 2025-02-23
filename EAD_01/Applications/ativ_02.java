package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

import java.util.Scanner;

public class ativ_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerList integerList = new IntegerList();

        System.out.println("Type numbers: ");
        integerList.addNumbers(5, sc);

        int sum = integerList.sum();

        System.out.println("The sum of the numbers you've inserted is equals to " + sum + ".");

        sc.close();
    }
}
