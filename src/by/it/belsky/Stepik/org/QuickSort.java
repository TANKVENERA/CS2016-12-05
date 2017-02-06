package by.it.belsky.Stepik.org;

import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * Created by misha on 31.01.2017.
 */
public class QuickSort {
    private static class Point implements Comparable<Point> {
        int x;
        int index;
        Point (int x, int index) {
            this.x = x;
            this.index = index;
        }
        @Override
        public int compareTo(Point o) {
            if ((x-o.x) !=0)
            return x-o.x;
            else
                return index- o.index;
        }
        @Override
        public String toString() {
            return "["+x + " : " +index+"]";
        }
    }
    public static void main(String[] args) {
        QuickSort instance = new QuickSort();
        int result [] =instance.Acces();
        for (int x : result)
            System.out.print(x+ " ");

    }
    private int [] Acces () {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String x [] = line.split(" ");
        Point[] point = new  Point[Integer.parseInt(x[0])*2 + Integer.parseInt(x[1])];
        int index = 0;
        int start = Integer.parseInt(x[0]);
        int stop = Integer.parseInt(x[1]);
        int result [] = new int[stop];
        for (int i = 0; i<start; i++) {
            if (start > stop) {
                int d = start;
                start = stop;
                stop = d;
            }
            String line2 = scanner.nextLine();
            String x1 [] = line2.split(" ");
            point[index++] = new Point(Integer.parseInt(x1[0]), -1);
            point[index++] = new Point(Integer.parseInt(x1[1]), stop+1);
        }
        for (int i = 0; i<stop; i++) {
            int x3 = scanner.nextInt();
            point[index++] = new Point(x3, i);
        }
        qsort(point, 0, point.length-1);
        int count = 0;
        for (Point z : point) {
            if (z.index <0)
                count++;
            else if (z.index > stop)
                count--;
            else
                result[z.index] = count;
            System.out.print(z +" ");
        }
        return result;
    }
    private int partition(Point[] point, int low, int high) {
        Point x = point[low]; // каждый раз берется опорный элемент, равный первому эл-ту массива
        int j = low;
        for (int i = low + 1; i <=high; i++) { // здесь каждый  след. элемент сравнивается с первым и переставляется местами
            // так, чтобы сначала шли элементы меньше  опорного , затем те, что больше
            if (point[i].compareTo(x) <= 0) {
                j = j + 1;
                Point temp = point[i];
                point[i] = point[j];
                point[j] = temp;
            }
        }
        Point temp = point[low];
        point[low] = point[j];
        point[j] = temp;
        return j; // в итоге возвращаем индекс, последнеего числа, меньшего либо равного опорному элементу
    }
    private void qsort(Point[] point, int low, int high) {
        if (low < high) {
            int j = partition(point, low, high);
            qsort(point, low, j - 1); // здесь рекурсивно вызываем сортировку  от нулевого до j-1 элемента
            qsort(point, j + 1, high); // от j+1 до последнего
        }
    }
//    private void qsort (Point[] point) {
//        qsort(point, 0, point.length-1);
//    }
}
