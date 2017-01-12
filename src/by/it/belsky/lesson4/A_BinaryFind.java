package by.it.belsky.lesson4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by misha on 12.01.2017.
 */
public class A_BinaryFind {
    public static void main(String[] args) throws FileNotFoundException {
        A_BinaryFind a_binaryFind = new A_BinaryFind();
        File file = new File(System.getProperty("user.dir") + "/src/" + "/by/it/belsky/lesson4/Adata.txt");

        System.out.println(a_binaryFind.BinarySearch(file));
    }

    ArrayList<Integer> BinarySearch(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        int array[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int array1[] = new int[k];
        for (int i = 0; i < k; i++) {
            array1[i] = scanner.nextInt();
        }
        for (int i = 0; i < array1.length; i++) {
            int l = 1;
            int r = n;
            while (l <= r) {
                int m = (l + r) / 2;
                if (array[m - 1] == array1[i]) {
                    list.add(m);
                    break;
                } else if (array[m - 1] > array1[i]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            if (l > r) {  // тут надо добавить условие, иначе будет добаляться -1 всякий раз
                // после break.
                list.add(-1);
            }
        }
        return list;
    }
}
