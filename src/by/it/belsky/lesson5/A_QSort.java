package by.it.belsky.lesson5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by misha on 13.01.2017.
 */
public class A_QSort {
    private int partition(double[] array, int low, int high) {
        double x = array[low];
        int j = low;
        for (int i = low + 1; i <array.length; i++) {
            if (array[i] <= x) {
                j = j + 1;
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        double temp = array[low];
        array[low] = array[j];
        array[j] = temp;
        return j;
    }

    private void qsort(double[] array, int low, int high) {
        if (low < high) {
            int j = partition(array, low, high);
            qsort(array, low, j-1);
            qsort(array, j + 1, high);
        }
    };
//    private void qsort (double[] array) {
//        qsort(array, 0, array.length-1);
//    }

    public static void main(String[] args) throws FileNotFoundException {
        A_QSort instance = new A_QSort();
        File file = new File(System.getProperty("user.dir") + "/src/by/it/belsky/lesson5/dataA.txt");
        Scanner scanner = new Scanner(file);
        int lines = scanner.nextInt(); // число отрезков (число камер)
        int events = scanner.nextInt();// число событий на площади (число точек)
        double[] array = new double[lines * 2 + events]; // массив, в котором будут собыитя , начало и
        // конец съемки камер
        int index = 0;
        for (int i = 0; i < lines; i++) {
            double start = scanner.nextInt();
            double stop = scanner.nextInt();
            if (start > stop) {
                double x = start;
                start = stop;
                stop = x;
            }
            array[index++] = start + 0.1;
            array[index++] = stop + 0.2;
        }
        for (int i = 0; i < events; i++) {
            double point = scanner.nextInt();
            array[index++] = point;
        }
        instance.qsort(array, 0, array.length);
//        for (double x : array) {
//            System.out.print(x +" ");
//        }
        int count = 0;
        for (double x : array) {
            if ((x - 0.1) % 1 == 0)
                count++;
            else if ((x - 0.2) % 1 == 0)
                count--;
            else
                System.out.println(count);

        }

    }
}

