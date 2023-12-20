package chuong3;

public class CholeskyDecomposition {
    public static void main(String[] args) {
        int n = 10;
        float[][] A = {
                {1, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 5, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 5, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 5, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 5, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 2, 5, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 2, 5, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 2, 5, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 2, 5}
        };


        xuatMaTran(A, n);
        choleskyDecomposition(A, n);

    }



    public static void xuatMaTran(float[][] A, int n) {
        System.out.println("Ma tran A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%6.2f\t", A[i][j]));
            }
            System.out.println();
        }
    }

    public static void choleskyDecomposition(float[][] matrix, int n) {
        float[][] lower = new float[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                float sum = 0;
                if (j == i) {
                    for (int k = 0; k < j; k++) {
                        sum += Math.pow(lower[j][k], 2);
                    }
                    lower[j][j] = (float) Math.sqrt(matrix[j][j] - sum);
                } else {
                    for (int k = 0; k < j; k++) {
                        sum += (lower[i][k] * lower[j][k]);
                    }
                    lower[i][j] = (matrix[i][j] - sum) / lower[j][j];
                }
            }
        }

        System.out.println("Ma tran L:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%6.2f\t", lower[i][j]));
            }
            System.out.println();
        }

        System.out.println("Nghich dao L:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%6.2f\t", lower[j][i]));
            }
            System.out.println();
        }
    }
}
