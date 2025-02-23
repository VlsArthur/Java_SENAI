package EAD_01.Applications;

import EAD_01.Entities.Matrix;

import java.util.Scanner;

public class ativ_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix matrix = new Matrix(3);

        System.out.println("Type a 3x3 matrix: ");
        matrix.addElements(sc);
        System.out.print("Now type a scalar number: ");
        int num = sc.nextInt();
        matrix.multiplyByNum(num);
        System.out.println("Resultant matrix: ");
        matrix.show();

        sc.close();
    }
}
