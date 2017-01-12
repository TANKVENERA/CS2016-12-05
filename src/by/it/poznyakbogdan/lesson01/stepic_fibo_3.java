package by.it.poznyakbogdan.lesson01;

import java.math.BigInteger;
import java.util.Scanner;
/**
 * Created by admin on 31.12.2016.
 */
public class stepic_fibo_3 {


        static BigInteger fibonaci(Long n) {
            BigInteger fib0 = BigInteger.ZERO;
            BigInteger fib1 = BigInteger.ONE;
            BigInteger fibo = BigInteger.ZERO;
            Long i = Long.valueOf(2);
            while(i <= n){
                fibo = fib1.add(fib0);
                fib0 = fib1;
                fib1 = fibo;
                i++;
            }

            return fibo;
        }


    public static void main(String[] args){

        // put your code here
        //Scanner s = new Scanner(System.in);
        //int n = s.nextInt();
        Long n = Long.valueOf(5);
        Long q = Long.valueOf(6);
        if(++n == q){
            System.out.println("equals");
        }else{
            System.out.println("non-equals");
        }
        //int m = s.nextInt();
//        BigInteger m1 = new BigInteger(Integer.toString(m));
//        BigInteger fibo1 = fibonaci(n);
//        BigInteger result = fibo1.mod(m1);
        System.out.println();
//        int n = 10;
//        int m = 2;
//        BigInteger fibo1 = fibonaci(n);
//        BigInteger fibo2 = fibonaci(m);
//        BigInteger result = fibo1.mod(fibo2);
       // System.out.println(fibo1 + " % " + fibo2 + " = " + result + ", " + BigInteger.);
    }

}
