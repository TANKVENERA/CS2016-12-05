package by.it.belsky.lesson6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by misha on 16.01.2017.
 */
public class A_LIS {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(System.getProperty("user.dir") + "/src/by/it/belsky/lesson6/dataA.txt");
      int x = LISBottomup(file);
        System.out.println(x);

    }

   static int LISBottomup (File file)  throws FileNotFoundException{
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        int [] array = new int[n];
        for (int i = 0; i<n; i++) {
            array [i] = scanner.nextInt();
        }
        int [] d = new int[n];
        for (int i = 0; i<array.length; i++) {
            d[i] = 1;
            for (int j = 0; j<i; j++) {
                    if (array[j]<array[i] && d[j]+1 >d[i]) // второе условие необходимо для того, чтобы проверить
                    // являются ли все числа последовательности возрастающими друг отонсительно друга. Например,
                    // 2 3 1 4 - четверка больше всех, однако единица, не будет входить в последов, так как
                        // она меньше двойки и тройки
                        d[i] = d[j] +1; // т е - индекс будет увеличиваться тогда, когда предыдущ индекс равен текущему
                // например 1 2 3 - для двойки индекс будет 2 и для тройки после сравнения с  1 индекс тоже будет равен два
                //и тройка также больше двойки. Следовательно, d[j]+1 >d[i] и d[i] = d[j] +1.
            }
        }
        int maxindex = d[0];
        for (int i = 0; i<d.length; i++) {
        if (maxindex<d[i])
            maxindex = d[i];
        }
        return maxindex;
    }
}
