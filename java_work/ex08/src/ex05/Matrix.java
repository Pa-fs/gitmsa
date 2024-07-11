package ex05;

public class Matrix {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        int n = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = n++;
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        view(matrix);

        for (int i = 0; i < 3; i++) {
            for (int j = 0, k = 2; j < k; j++, k--) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }

        view(matrix);
    }

    private static void view(int[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
