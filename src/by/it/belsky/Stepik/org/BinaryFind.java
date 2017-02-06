package by.it.belsky.Stepik.org;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by misha on 31.01.2017.
 */
public class BinaryFind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int arrayk [] = new int[k];
        for (int i = 0; i < k; i++) {
            arrayk [i] = scanner.nextInt();
        }
        ArrayList<Integer> result = new ArrayList<>();
        binaryFind(result, array, arrayk);
        for (int x : result)
            System.out.print(x + " ");
    }

    public static void binaryFind(ArrayList result, int array[], int arrayk[]) {
        for (int i = 0; i < arrayk.length; i++) { // огромная ошибка!!! цикл надо изменять по длине массива чисел (bi),
            // т. к. их может быть меньше  и так сказано в условии (Для каждого i от 1 до k необходимо вывести индекс)

            int left = 1;
            int right = array.length;
            while (left <= right) {
                int m = (left + right) / 2;
                if (array[m - 1] == arrayk[i]) {
                    result.add(m);
                    break;
                } else if (array[m - 1] > arrayk[i]) {
                    right = m - 1;
                } else {
                    left = m + 1;
                }
            }
            if (left > right) {
                result.add(-1);
            }
        }
    }
}
