package by.it.belsky.Stepik.org;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by misha on 19.01.2017.
 */
public class lkhvkhgl {

        public static void main(String[] args) throws IOException {
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            Scanner read = new Scanner(line);
            long n = read.nextLong();
            long m = read.nextLong(); // почему то приняло ответ только когда  делитель  приравнять к типу long
            int k = 0;
            long[] F = new long[10000000];
            F[0] = 0;
            F[1] = 1;
            for (int i = 2; i <= m * m + 1; i++) {
                F[i] =(F[(i - 1)] + F[(i - 2)]) % m;
                k = k + 1;
                if (F[i] == 1 && F[(i - 1)] == 0) {
                     long res = n%k;
                    int res1 = (int)res;
                    System.out.println(F[res1]);
                    break;
                }
            }
        }
    }