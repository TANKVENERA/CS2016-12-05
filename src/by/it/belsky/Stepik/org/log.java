package by.it.belsky.Stepik.org;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by misha on 25.01.2017.
 */
public class log {
    public static void main(String[] args) {
        //double y = Math.log10(8)/Math.log10(2); // это логарифм по основанию два  числа 8 -log2(8)=3
        int x1 =10000;
        int i = 1;
        System.out.println(Math.log10(31622) / Math.log10(2));

        BigDecimal y1 = BigDecimal.valueOf(2).pow(3*x1); //2в ст 3n
        System.out.printf("%d: %e %12s\n",i++, y1, "2в ст 3n");
        double y2 = Math.pow(7, Math.log10(x1) / Math.log10(2)); // 7 в степени log2(n)
        System.out.printf("%d: %4.4e %25s\n",i++, y2,  "7 в степени log2(n)");
        double y3 = Math.pow(3, Math.log10(x1) / Math.log10(2)); // 3 в степени log2(n)
        System.out.printf("%d: %4.4e %25s\n",i++, y3,  "3 в степени log2(n)");
        BigDecimal y4 = BigDecimal.valueOf(4).pow(x1);// 4 в степени n
        System.out.printf("%d: %e %10s\n",i++, y4, "4 в степени n");
        double y5 = Math.log10(x1) / Math.log10(3); // log3(n)
        System.out.printf("%d: %e %10s\n",i++, y5, "log3(n)");
        double y6 = Math.pow(Math.log10(x1) / Math.log10(2), Math.log10(x1) / Math.log10(2));// log2(n) в степени log2(n);
        System.out.printf("%d: %e %15s\n",i++, y6, "log2(n) в степени log2(n)");
        double y7 = Math.log10(Math.log10(x1) / Math.log10(2)) / Math.log10(2); // log2(log2(n))
        System.out.printf("%d: %e %15s\n",i++, y7, "log2(log2(n)");
        double y8 = Math.sqrt(Math.log10(x1) / Math.log10(4)); // корень из log4 (n)
        System.out.printf("%d: %e %15s\n",i++, y8, "корень из log4(n)");
//        BigDecimal y9 = BigDecimal.valueOf(2).pow((int)(Math.pow(2, x1))); //2 в степени  2 в ст n
//        System.out.printf("%d: %e %15s\n",i++, y9, "2 в степени 2 в ст n");
        double y10 = Math.pow(Math.log10(x1) / Math.log10(2), 2); // log2 (n) в степени 2
        System.out.printf("%d: %e %15s\n",i++, y10, "log2 (n) в степени 2");
        BigDecimal y11 = BigDecimal.valueOf(x1).pow((int)(Math.pow(x1, 0.5))); // n в ст корень из n
        System.out.printf("%d: %e %15s\n",i++, y11, "n в ст корень из n");
        BigDecimal y12 = BigDecimal.valueOf(2).pow(x1);// 2 в степени n
        System.out.printf("%d: %e %15s\n",i++, y12, "2 в степени n");
        double y13 = Math.pow(x1, 2); // n в степени 2
        System.out.printf("%d: %e %15s\n",i++, y13, "n в степени 2");
        double y14 = Math.pow(x1, Math.log10(x1)/Math.log10(2)); // n в ст. log2(n)
        System.out.printf("%d: %e %15s\n",i++, y14, " n в ст. log2(n)");
//        double y15 = BigDecimal.valueOf(Math.log10(()factorial(x1))/Math.log10(2)); // log2(n!)
//        System.out.println(i++ + ": " + y15);
        double y16 =x1/(Math.log10(x1)/Math.log10(5)); // n/log5(n)
        System.out.printf("%d: %e %15s\n",i++, y16, " n/log5(n)");
        double y17 = Math.sqrt(x1); // корень из n
        System.out.printf("%d: %e %15s\n",i++, y17, " корень из n");
        BigDecimal y18 = factorial(x1); // n!
        System.out.println(x1*Math.log10(x1));
        System.out.printf("%d: %e %15s\n",i++, y18, "n!");
        Map <BigDecimal, String> map = new TreeMap<>();
        map.put(y1,  "2в ст 3n");
//        map.put(y2,  "7 в степени log2(n)");
//        map.put(y3,  "3 в степени log2(n)");
        map.put(y4,  "4 в степени n");
//        map.put(y5,  "log3(n)");
//        map.put(y6,  "log2(n) в степени log2(n)");
//        map.put(y7,  "log2(log2(n))");
//        map.put(y8,  "корень из log4(n)");
//        map.put(y9,  "2 в степени 2 в ст n");
//        map.put(y10, "log2(n) в ст 2");
//        map.put(y11, "n в ст корень из n");
//        map.put(y12, "2 в степени n");
//        map.put(y13, "n в степени 2");
//        map.put(y14, "n в степени log2(n)");
//       // map.put(y15, "log2(n!)");
//        map.put(y16, "n/log5(n)");
//        map.put(y17,"корень из n");
            map.put(y18,"n!");
        int z =1;
        for (Map.Entry<BigDecimal, String> x : map.entrySet()){
            System.out.printf("%d: %10.4e   %-10s \n",z++, x.getKey(), x.getValue());
        }

    }

    public static BigDecimal factorial(int x) {
        BigDecimal res = BigDecimal.valueOf(1);
        for (int i = 1; i <= x; i++) {
            res = res.multiply(BigDecimal.valueOf(i));
        }
        return res;
    }



}

