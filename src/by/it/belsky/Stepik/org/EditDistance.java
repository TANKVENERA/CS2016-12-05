package by.it.belsky.Stepik.org;

import java.util.Scanner;

/**
 * Created by misha on 01.02.2017.
 */
public class EditDistance {
      String line1;
      String line2;
    int [][] Massiv;
    boolean [][] calc;
    public int editingDistance (int n, int m) {
        if (n==0 && m==0)
            return 0;
        if (n==0)
            return m;
        if (m==0)
            return n;
        if (calc[n][m])
            return
            Massiv[n][m];
        int result1 = editingDistance(n, m-1) +1;
        int result2 = editingDistance(n-1, m) +1;
        int result3 = editingDistance(n-1, m-1) +(line1.charAt(n-1) == line2.charAt(m-1) ? 0 :1);
        int distance = Math.min(Math.min(result1, result2), result3);
        calc[n][m] = true;
        Massiv [n][m] = distance;
        return distance;
    }
    public void  run  () {
        Scanner scanner = new Scanner(System.in);
        line1 = scanner.nextLine();
        line2 = scanner.nextLine();
        Massiv = new int[line1.length()+1][line2.length()+1];
        calc = new boolean[line1.length()+1][line2.length()+1];
        System.out.println(editingDistance(line1.length(), line2.length()));
    }

    public static void main(String[] args) {
        EditDistance instance = new EditDistance();
        long time1 = System.currentTimeMillis();
        instance.run();
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1+" ms");
    }

}
