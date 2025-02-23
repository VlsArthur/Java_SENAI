package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

import java.util.Scanner;

public class ativ_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerList integerList = new IntegerList();

        System.out.println("Type numbers: ");
        integerList.addNumbers(10, sc);
        System.out.print("You've inserted: ");
        integerList.show();
        System.out.print("Even numbers: ");
        integerList.showEven();

        sc.close();
    }
}
