package by.it.belsky.Stepik.org;

import java.util.Scanner;

/**
 * Created by misha on 19.01.2017.
 */
public class MultipleQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String linearray = scanner.nextLine();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int[] D = new int[n]; // массив индексов
        for (int i = 0; i < A.length; i++) {
            D[i] = 1;
            for (int j = 0; j <i; j++) {
                if (A[i] % A[j] == 0 && D[j] + 1 > D[i]) {
                    D[i]++;
                }
            }
        }
        int maxindex = 0;
        for (int i = 0; i < D.length; i++) {
           maxindex = Math.max(maxindex, D[i]);
        }
        System.out.println(maxindex);
    }
}

