package chuong1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ak_mod_n {
    public int nhapso() throws IOException {
        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ISR);
        String s = br.readLine();
        return Integer.parseInt(s);
    }

    public static int kq(int a, int k,int n) {
        if (n == 1) {
            return 0;
        }

        int result = 1;

        a = a % n;


        while (k > 0) {
            if (k % 2 == 1) {
                result = (result * a) % n;
            }

            k /=2;
            a = (a * a) % n;
        }

        return result;
    }

    public static void main(String[] args) {
        int a=0,k=0,n=0;

        ak_mod_n tt = new ak_mod_n();
        try {
            do
            {
                System.out.print("Nhap so nguyen duong a: ");
                a = tt.nhapso();

                System.out.print("Nhap so nguyen duong k: ");
                k = tt.nhapso();

                System.out.print("Nhap so nguyen duong n: ");
                n = tt.nhapso();

            } while ((a<=0) || (k<=0) || (n<=0));
        } catch (Exception e) {};

        System.out.println(kq(a,k,n));

    }
}
