package by.it.belsky.Stepik.org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by misha on 17.01.2017.
 */
public class LastFiboNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] fibo = new long[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        long MOD =(long) 1e15;
        for (int i = 2; i < fibo.length; i++) {
            fibo[i] =  (fibo[i - 1] +(fibo[i - 2]))%MOD;

        }
        System.out.println((fibo[n-1]+fibo[n-2])%10); // если решать через BigInteger - то проходит слишком много
        // времени , надо число делить на большую постоянную(константу) - и тогда скорость увеличится


    }
}



