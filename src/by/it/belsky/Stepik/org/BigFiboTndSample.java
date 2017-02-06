package by.it.belsky.Stepik.org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by misha on 18.01.2017.
 */
public class BigFiboTndSample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Scanner read = new Scanner(line);
        long n = read.nextLong();
       long m = read.nextLong();
        int k = 0;
        List<Long> list = new ArrayList<>();
        list.add((long)0);
        list.add((long)1);
        for (int i = 2; i<m*m+1; i++) {
                list.add((list.get(i-1)+list.get(i-2))%m);

            k=k+1;
            if (list.get(i)==1 && list.get(i-1)==0) {
                long res = n%k;
                int res1 = (int) res;
                System.out.println(list.get(res1));
                break;
            }
        }

    }
}
