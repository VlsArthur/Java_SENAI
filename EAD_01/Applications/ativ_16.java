package EAD_01.Applications;

import EAD_01.Entities.Matrix;

import java.util.Scanner;

public class ativ_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type the order of a identity matrix: ");
        int order = sc.nextInt();

        Matrix matrix = new Matrix(order);
        matrix.getIdentity();

        System.out.println("It should looks like: ");
        matrix.show();

        sc.close();
    }
}
