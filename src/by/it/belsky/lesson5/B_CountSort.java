package by.it.belsky.lesson5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by misha on 15.01.2017.
 */
public class B_CountSort {
    public static void main(String[] args)  throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir")+ "/src/by/it/belsky/lesson5/dataB.txt");
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int [] array = new int[n];
        for (int i = 0; i <n; i ++) {
                array[i] = scanner.nextInt();
            if (min>array[i])
                min = array[i];
            if (max<array[i])
                max = array[i];
        }
        int [] array2 = new int[n];
        System.arraycopy(array, 0, array2, 0, array.length);

        long start = System.currentTimeMillis();
     sort(array, min, max) ;
        System.out.println(System.currentTimeMillis() - start);
        for (int x : array) {
            System.out.print(x);
        }
        System.out.println("");

        long start1 = System.currentTimeMillis();
        Arrays.sort(array2);
        System.out.println(System.currentTimeMillis() - start1);
        for (int x : array2) {
            System.out.print(x);
        }


    }
    static int [] sort (int [] array, int min , int max) {
        int [] count = new int[max-min+1];
        for (int i = 0; i<array.length; i++) {
                count[array[i]- min] =  count[array[i]- min]+1;
        } // тут в массив загнали  9-2 +1 = 8 количеств повторений для  различных вариантов чисел (2, 3, 4 ,5 ,6 ,7 ,8 ,9)
        // например двойка повторяется 2 раза
        int index = 0;
        //пробежим по всему массиву count:
        for (int i = 0; i<count.length; i++) {
               // int j = count[i]; // например двойка повторятеся 2 раза
            for (int j = 0; j<count[i]; j++) {
                array[index] = i + min;
                index++;
            }
        }
        return array;
    }
}
