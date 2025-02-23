package EAD_01.Applications;

import EAD_01.Entities.Matrix;

import java.util.Scanner;

public class ativ_29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix matrix = new Matrix(4);

        System.out.println("Type a 4x4 matrix: ");
        matrix.addElements(sc);
        matrix.showSumOfAllColumns();
    }
}
