package by.it.belsky.lesson6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by misha on 16.01.2017.
 */
public class B_LongDiv {
    int[] LISBottomup (int[] array) {
        int[] d = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && array[i] % array[j] == 0 && d[j] + 1 > d[i]) // Тоже, что и в предыдущей
                    // задаче, только необходимо проверить на деление без остатка, первое условие можно выкинуть, так
                // если делится  без остатка, то число  само по себе больше
                    d[i] = d[j] + 1;
            }
        }
        return d;
    }
    int FindMaxIndex (int[] d) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<d.length; i++) {
            if (max<d[i])
                max = d[i];
        }
        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {
        B_LongDiv instance = new B_LongDiv();
        File file = new File(System.getProperty("user.dir") + "/src/by/it/belsky/lesson6/dataB.txt");
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int [] d = instance.LISBottomup(array);
        System.out.println(instance.FindMaxIndex(d));

    }
}
