package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

import java.util.ArrayList;
import java.util.Scanner;

public class ativ_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerList integerList1 = new IntegerList();
        IntegerList integerList2 = new IntegerList();

        System.out.println("Type numbers: ");
        integerList1.addNumbers(5, sc);
        System.out.println("Type numbers: ");
        integerList2.addNumbers(5, sc);

        ArrayList<Integer> arrayList = integerList1.getList();
        arrayList.addAll(integerList2.getList());
        IntegerList integerList3 = new IntegerList(arrayList);

        System.out.print("Merging the inserted lists we have: ");
        integerList3.show();
    }
}
