package by.it.sazonov_valery.lesson08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Рекурсивно вычислить расстояние редактирования двух данных непустых строк

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    0

    Sample Input 2:
    short
    ports
    Sample Output 2:
    3

    Sample Input 3:
    distance
    editing
    Sample Output 3:
    5

*/

public class A_EditDist {

    private static int[][] d;
    private char[] firstArray;
    private char[] secondArray;

    int getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        firstArray = one.toCharArray();
        secondArray = two.toCharArray();

        int n = firstArray.length + 1;
        int m = secondArray.length + 1;
        d = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }

        int result = EditDis(n - 1, m - 1);

        return result;
    }

    private int EditDis(int i, int j) {
        if (d[i][j] == Integer.MAX_VALUE) {
            if (i == 0) d[i][j] = j;
            else if (j == 0) d[i][j] = i;
            else {
                int ins = EditDis(i, j - 1) + 1;
                int del = EditDis(i - 1, j) + 1;
                int rep;
                if (firstArray[i - 1] == secondArray[j - 1]) {
                    rep = EditDis(i - 1, j - 1);    //если совпадение
                } else {
                    rep = EditDis(i - 1, j - 1) + 1;  //иначе замена
                }
                d[i][j] = min(ins, del, rep);
            }
        }
        return d[i][j];
    }

    public int min(int a, int b, int c) {
        if (a < b && a < c) return a;
        if (b < a && b < c) return b;
        else return c;
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelov/lesson08/dataABC.txt");
        A_EditDist instance = new A_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
    }
}

