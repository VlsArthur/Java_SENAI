package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

import java.util.Scanner;

public class ativ_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerList integerList = new IntegerList();

        System.out.println("Type numbers: ");
        integerList.addNumbers(10, sc);
        integerList.removeOddNumbers();
        System.out.print("Inserted list without the odd numbers: ");
        integerList.show();
        sc.close();
    }
}
