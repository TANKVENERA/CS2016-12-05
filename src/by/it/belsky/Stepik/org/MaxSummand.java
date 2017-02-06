package by.it.belsky.Stepik.org;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by misha on 01.02.2017.
 */
public class MaxSummand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int i = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (; ; ) {
            if (i < number && i + 1 <=number - i) { // здесь условие, чтобы первое слагаемое было
                // меньше самого числа и  след. слагаемое было меньше  либо равно числу за вычетом
                // cлед. слагаемого
                number = number - i;
                list.add(i++);
            } else if (i < number && i + 1 > number - i) { // если уже след слагаемое больше оставшегося числа,
                // то  слагаемое = остатку и break;
                i = number;
                list.add(i);
                break;
            }
            else if (i == number) { // здесь проверка на равенство , если слагаемое равно остатку , записываем
                // в лист и break  все!!!
                list.add(i);
                break;
            }
        }
        System.out.println(list.size());
        for (int element : list) {
            System.out.print(element+" ");
        }
    }
}
