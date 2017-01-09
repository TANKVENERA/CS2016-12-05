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
    Итерационно вычислить расстояние редактирования двух данных непустых строк

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

public class B_EditDist {


    int getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        char[] firstArray = one.toCharArray();
        char[] secondArray = two.toCharArray();

        int n = firstArray.length + 1;
        int m = secondArray.length + 1;
        int[][] d = new int[n][m];

        for (int i = 0; i < n; i++) d[i][0] = i;
        for (int j = 1; j < m; j++) d[0][j] = j;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int ins = d[i][j - 1] + 1;
                int del = d[i - 1][j] + 1;

                int rep;
                if (firstArray[i - 1] == secondArray[j - 1]) {
                    rep = d[i - 1][j - 1];      //если совпадение
                } else {
                    rep = d[i - 1][j - 1] + 1;  //иначе замена
                }
                d[i][j] = Math.min(ins, Math.min(del, rep));
            }
        }

        int result = d[n - 1][m - 1];

        return result;
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelov/lesson08/dataABC.txt");
        B_EditDist instance = new B_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
    }

}
