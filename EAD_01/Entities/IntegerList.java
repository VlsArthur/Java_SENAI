package EAD_01.Entities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IntegerList {
    private ArrayList<Integer> list;

    public IntegerList() {
        list = new ArrayList<Integer>();
    }

    public IntegerList(ArrayList<Integer> list) {
        this.list = list;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void show() {
        for (int number : list) {
            System.out.print(number + ", ");
        }
        System.out.println("\b\b.");
    }

    public void addNumbers(int quantity, Scanner scanner) {
        for (int i = 0; i < quantity; i++) {
            list.add(scanner.nextInt());
        }
    }

    public int sum() {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return sum;
    }

    public double avg() {
        int sum = sum();
        return (double) sum / list.size();
    }

    public void getRandom(int quantity, int origin, int bound) {
        Random random = new Random();
        for (int i = 0; i < quantity; i++) {
            list.add(random.nextInt(origin, bound));
        }
    }

    public int max() {
        int max = Integer.MIN_VALUE;
        for (int number : list) {
            max = Math.max(number, max);
        }
        return max;
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for (int number : list) {
            min = Math.min(number, min);
        }
        return min;
    }

    public void removeOddNumbers() {
        int toBeRemovedIndex = 0;
        boolean hasOdd = false;
        for (int number : list) {
            if (number%2>0) {
                toBeRemovedIndex = list.indexOf(number);
                hasOdd = true;
                break;
            }
        }
        if (hasOdd) {
            list.remove(toBeRemovedIndex);
            removeOddNumbers();
        }
    }

    public void sort() {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i-1;
            while (j >=0 && key < list.get(j)) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, key);
        }
    }

    public void reverse() {
        ArrayList<Integer> reversedList = new ArrayList<Integer>();
        for (int number : list) {
            reversedList.addFirst(number);
        }
        list.clear();
        list.addAll(reversedList);
    }

    public void multiplyByNum(int num) {
        ArrayList<Integer> resultantList = new ArrayList<Integer>();
        for (int number : list) {
            resultantList.add(number * num);
        }
        list.clear();
        list.addAll(resultantList);
    }

    public void showEven() {
        for (int number : list) {
            if (number % 2 == 0) {
                System.out.print(number + ", ");
            }
        }
        System.out.println("\b\b.");
    }

    public void removeNegativeValues() {
        ArrayList<Integer> resultantList = new ArrayList<Integer>();
        for (int number : list) {
            resultantList.add((Math.max(number, 0)));
        }
        list.clear();
        list.addAll(resultantList);
    }

}
