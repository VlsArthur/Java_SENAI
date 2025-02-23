package EAD_01.Applications;

import java.util.ArrayList;
import java.util.Scanner;

public class ativ_08 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Type names: ");
        addElements(arrayList, 5, sc);
        sortStringList(arrayList);
        System.out.print("Inserted names in alphabetic order: ");
        showList(arrayList);

        sc.close();
    }

    public static void showList(ArrayList<String> list) {
        for (Object name : list) {
            System.out.print(name + ", ");
        }
        System.out.println("\b\b.");
    }

    public static void addElements(ArrayList<String> list, int quantity, Scanner scanner) {
        for (int i = 0; i < quantity; i++) {
            list.add(scanner.next());
        }
    }

    public static void sortStringList(ArrayList<String> list) {
        for (int i = 1; i < list.size(); i++) {
            String key = list.get(i);
            int j = i-1;
            while (j >= 0 && key.compareToIgnoreCase(list.get(j))<0) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, key);
        }
    }
}
