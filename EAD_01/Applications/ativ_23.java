package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

import java.util.Scanner;

public class ativ_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerList integerList = new IntegerList();

        System.out.println("Type numbers: ");
        integerList.addNumbers(5, sc);
        System.out.print("Now type a number to be multiplied by every single inserted number: ");
        int num = sc.nextInt();
        integerList.multiplyByNum(num);
        System.out.println("Resultant list: ");
        integerList.show();

        sc.close();
    }
}
