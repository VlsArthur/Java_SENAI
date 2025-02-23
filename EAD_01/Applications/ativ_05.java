package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

import java.util.ArrayList;
import java.util.Scanner;

public class ativ_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerList integerList = new IntegerList();

        System.out.println("Type numbers: ");
        integerList.addNumbers(5, sc);
        System.out.print("Type a number: ");
        int num = sc.nextInt();
        ArrayList<Integer> arrayList = integerList.getList();
        String result = "You" + ((arrayList.contains(num)) ? "'ve" : " haven't") + " inserted this number before.";
        System.out.println(result);

        sc.close();
    }
}
