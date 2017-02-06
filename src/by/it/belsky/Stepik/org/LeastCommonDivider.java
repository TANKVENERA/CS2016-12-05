package by.it.belsky.Stepik.org;

import java.util.Scanner;

/**
 * Created by misha on 21.01.2017.
 */
public class LeastCommonDivider {
    private int Euclid(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a >= b) {
            return Euclid(a % b, b);
        } else return Euclid(a, b % a);

        // любое число - оно не должно возвращаться
    }

    public static void main(String[] args) {
        LeastCommonDivider instance = new LeastCommonDivider();
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.next());
        int b = Integer.parseInt(scanner.next());
        System.out.println(instance.Euclid(a, b));

    }
}
