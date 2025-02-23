package EAD_01.Applications;

import EAD_01.Entities.Matrix;

import java.util.Scanner;

public class ativ_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix matrix = new Matrix(4);

        matrix.getRandom(1, 9);
        System.out.println("Generated matrix: ");
        matrix.show();
        double avg = matrix.avg();
        System.out.print("Its average: " + String.format("%,2f", avg));

        sc.close();
    }
}
