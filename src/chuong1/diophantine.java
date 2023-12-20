package chuong1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class diophantine {
    public int nhapso() throws IOException {
        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ISR);
        String s = br.readLine();
        return Integer.parseInt(s);
    }

    public static int gcd(int a,int b) {
        if (b==0) {
            return a;
        }
        else {
            return gcd(b , a%b);
        }
    }


    public static void main(String[] args) {
        int a =0, b=0, c=0;
        diophantine pt = new diophantine();
        try {

            System.out.println("ax + by = c   || a, b, c la so nguyen.\n");

            System.out.print("Nhap a: ");
            a = pt.nhapso();

            System.out.print("Nhap b: ");
            b = pt.nhapso();

            System.out.print("Nhap c: ");
            c = pt.nhapso();

        } catch (Exception e) {};
        //
        int d = gcd(a,b);
        int q = 0;


        if (c%d != 0) {
            System.out.println("Phuong trinh khong co nghiem nguyen");
        }

        else {
            q = c / d;
            int k = 1, l=0;

            boolean check = false; // false => a<b ; true => a>b

            int tmp1=0, tmp2; // tmp1 > tmp2
            if (a>b) {
                check = true;
                tmp1 = a;
                tmp2 = b;
            }
            else {
                tmp1 = b;
                tmp2 = a;
            }

            while (true) {
                if (d - k*tmp1 % tmp2 == 0) {
                    l = (d - k*tmp1) / tmp2;
                    break;
                }
                else
                    k++;
            }

//			if (check) {
//				System.out.println(k + "*a + " + l + "*b = " + d);
//			}
//			else {
//				System.out.println(l + "*a + " + k + "*b = " + d);
//			}
            if (!check) {
                int tmp = k;
                k = l;
                l = tmp;
            }
            //System.out.println(k + "*a + " + l + "*b = " + d);
            int x = q*k;
            int y = q*l;
            System.out.println("Nghiem cua phuong trinh: x = " + x + " ,  y = " + y);
            System.out.println("Nghiem Tong Quat: x = " + x + " + " + b/d +"*r  ,  y = " + y + " - " + a/d + "*r" );

        }
    }
}
