package by.it.belsky.Stepik.org;

import java.io.IOException;
import java.util.Scanner;


/**
 * Created by misha on 17.01.2017.
 */
public class BigFibo {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Scanner read = new Scanner(line);
        long n = read.nextLong();
        long m = read.nextLong();
        int k = 0;
        long[] F = new long[10000000];
        F[0] = 0%m;
        F[1] = 1%m;
        for (int i = 2; i <= m * m + 1; i++) {
         F[i] = (F[(i - 1)] + F[(i - 2)]) % m;
            k = k + 1;
            if (F[i] ==  1 && F[(i - 1)] == 0) {
                long res = n%k;
                int res1 = (int) res;
                System.out.println(res1);
                System.out.println("остаток от деления n-го числа = : " + F[res1]);
                break;
            }

            System.out.println("i= "+i + " ост= " +F[i]+ " k= "+k);
        }
        System.out.println("длина периода пизано k = " + k);

    }
}