package EAD_01.Applications;

import EAD_01.Entities.Matrix;

import java.util.Scanner;

public class ativ_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix matrix = new Matrix(3);

        System.out.println("Type a 3x3 matrix: ");
        matrix.addElements(sc);
        int max = matrix.max();
        System.out.println("Greatest matrix element: " + max + ".");

        sc.close();
    }
}
