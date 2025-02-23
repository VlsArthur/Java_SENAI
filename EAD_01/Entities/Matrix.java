package EAD_01.Entities;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private int[][] matrix;

    public Matrix(int order) {
        this.matrix = new int[order][order];
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void addElements(Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public void show() {
        for (int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + ", ");
            }
            System.out.println("\b\b");
        }
    }

    public int sum() {
        int sum = 0;
        for (int[] row : matrix) {
            for (int column : row) {
                sum += column;
            }
        }
        return sum;
    }

    public int max() {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int column : row) {
                max = Math.max(max, column);
            }
        }
        return max;
    }

    public int sumMainDiagonal() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i==j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
    public int sumCounterdiagonal() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i+j==matrix.length-1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public void getIdentity() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i==j) ? 1 : 0;
            }
        }
    }

    public void multiplyByNum(int num) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= num;
            }
        }
    }

    public void getRandom(int origin, int bound) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(origin, bound);
            }
        }
    }

    public double avg() {
        int sum = sum();
        int elements = matrix.length * matrix[0].length;
        return (double) sum / elements;
    }

    public void transpose() {
        int[][] transposeOfMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposeOfMatrix[i][j] += matrix[j][i];
            }
        }
        setMatrix(transposeOfMatrix);
    }

    public int sumRow(int row) {
        int sum = 0;
        for (int column : matrix[row]) {
            sum += column;
        }
        return sum;
    }

    public void showSumOfAllRows() {
        for (int i = 0; i < matrix.length; i++) {
            int sum = sumRow(i);
            System.out.println("Sum of line " + (i+1) + ": " + sum);
        }
    }

    public int sumColumn(int column) {
        int sum = 0;
        for (int[] row : matrix) {
            sum += row[column];
        }
        return sum;
    }

    public void showSumOfAllColumns() {
        for (int i = 0; i < matrix.length; i++) {
            int sum = sumColumn(i);
            System.out.println("Sum of column " + (i+1) + ": " + sum);
        }
    }

}
