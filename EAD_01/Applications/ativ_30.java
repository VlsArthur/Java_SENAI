package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

import java.util.Scanner;

public class ativ_30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerList integerList = new IntegerList();

        System.out.println("Type numbers: ");
        integerList.addNumbers(5, sc);
        integerList.removeNegativeValues();
        System.out.println("Inserted list but with negative values changed by 0: ");
        integerList.show();

        sc.close();
    }
}
