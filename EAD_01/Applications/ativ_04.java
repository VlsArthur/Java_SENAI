package EAD_01.Applications;

import EAD_01.Entities.IntegerList;

public class ativ_04 {
    public static void main(String[] args) {
        IntegerList integerList = new IntegerList();

        integerList.getRandom(10, 1, 100);
        System.out.print("Generated list: ");
        integerList.show();
        int max = integerList.max();
        System.out.println("Greatest value: " + max + ".");
        int min = integerList.min();
        System.out.println("Greatest value: " + min + ".");
    }
}
