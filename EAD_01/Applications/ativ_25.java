package EAD_01.Applications;

import java.util.ArrayList;
import java.util.Scanner;

public class ativ_25 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Type names: ");
        addElements(arrayList, 5, sc);
        showGreetings(arrayList);

        sc.close();
    }

    public static void showGreetings(ArrayList<String> list) {
        for (Object name : list) {
            System.out.println("Hello, " + name + "!");
        }
    }

    public static void addElements(ArrayList<String> list, int quantity, Scanner scanner) {
        for (int i = 0; i < quantity; i++) {
            list.add(scanner.next());
        }
    }

}
