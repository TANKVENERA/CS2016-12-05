package by.it.belsky.Stepik.org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by misha on 20.01.2017.
 */
public class NonIncreaseQueue {
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
            for (int j = 0; j < i; j++) {
                if (A[i] <= A[j] && D[j] + 1 > D[i]) {
                    D[i]++;
                }
            }
        }
        int maxindex = 0;
        for (int i = 0; i < D.length; i++) {
            maxindex = Math.max(maxindex, D[i]);
        }
        System.out.println(maxindex);
        System.out.println("");
        int k = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = D.length - 1; i >= 0; ) {
            if (D[i] == maxindex) {
                list.add(0, i+1);
                for (int j = i - 1; j >= 0; j--) {
                    if (D[j] + 1 ==maxindex) {
                        maxindex--;
                        list.add(0,j+1);
                    }
                }
                break;
            }
            else
                i--;
        }
        for (int x : list) {
            System.out.print(x+" ");
        }

    }
}

