package by.it.belsky.lesson4;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


/**
 * Created by misha on 12.01.2017.
 */
public class B_MergeSort {
    public static void main(String[] args) throws FileNotFoundException {
        B_MergeSort mergeSort = new B_MergeSort();
        File file = new File(System.getProperty("user.dir") + "/src/" + "/by/it/belsky/lesson4/Bdata.txt");
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Long startTime = System.currentTimeMillis();
        int[] result = mergeSort.MergeSort(array);
        Long endTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);
        for (int x : result) {
            System.out.println(x);
        }

    }

    int[] Merge(int array1[], int array2[]) {
        int i = 0;
        int j = 0;
        int mk[] = new int[array1.length + array2.length];
        for (int k = 0; k < mk.length; k++) {
            if (j == array2.length || i < array1.length && array1[i] <= array2[j]) {
                mk[k] = array1[i++];

            } else
                mk[k] = array2[j++];


        }
        return mk;
    }

    int[] MergeSort(int[] m) {

        int left[] = new int[m.length / 2];
        int right[] = new int[m.length - left.length];
        System.arraycopy(m, 0, left, 0, left.length);
        System.arraycopy(m, left.length, right, 0, right.length);

        if (left.length > 1 && right.length > 1) {
            left = MergeSort(left);
            right = MergeSort(right);
        }
        return Merge(left, right);
    }
}

