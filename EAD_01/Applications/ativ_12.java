package EAD_01.Applications;

import EAD_01.Entities.Matrix;

import java.util.Scanner;

public class ativ_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix matrix = new Matrix(3);

        System.out.println("Type a 3x3 matrix: ");
        matrix.addElements(sc);
        int sum = matrix.sum();
        System.out.println("The sum of all of the inserted matrix elements is equals to: " + sum + ".");

        sc.close();
    }
}
