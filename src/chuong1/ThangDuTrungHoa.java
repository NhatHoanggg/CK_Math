package chuong1;

import java.util.Scanner;

public class ThangDuTrungHoa {
    public static int solve(int[] m, int[] a, int k) {
        int x = 1;
        while (true) {
            int j;
            for (j = 0; j < k; j++) {
                if (x % m[j] != a[j]) {
                    break;
                }
            }
            if (j == k) {
                return x;
            }
            x++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so phuong trinh k = ");

        int k = scanner.nextInt();

        int[] a = new int[k];

        for (int i = 0; i < k; i++) {
            System.out.print("A[" + (i + 1) + "] = ");
            a[i] = scanner.nextInt();
        }


        int[] m = new int[k];

        for (int i = 0; i < k; i++) {
            System.out.print("M[" + (i + 1) + "] = ");
            m[i] = scanner.nextInt();
        }


        int result = solve(m, a, k);
        System.out.println("Ket qua x = " + result );
    }
}
