package by.it.belsky.Stepik.org;

import java.util.Scanner;

/**
 * Created by misha on 29.01.2017.
 */
public class B_CountSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int array[] = new int[a];
        for (int i = 0; i < a; i++) {
            array[i] = scanner.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        sort(array, min, max);
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public static void sort(int array[], int min, int max) {
        int count[] = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min] = count[array[i] - min] + 1;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[index] = i + min;
                index++;
            }
        }
    }
}
