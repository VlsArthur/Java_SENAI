package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

import java.util.Scanner;

public class ativ_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerList integerList = new IntegerList();

        System.out.println("Type numbers: ");
        integerList.addNumbers(7, sc);
        integerList.reverse();
        System.out.println("Inserted list in reverse order: ");
        integerList.show();
    }
}
