package by.it.poznyakbogdan.lesson01;

/**
 * Created by admin on 01.01.2017.
 */
public class stepic_numbers {

    public static void main(String[] args) {
        // put your code here
        //Scanner s = new Scanner(System.in);
        int n = 63;//s.nextInt();
        int i = 1;
        int k = 1;
        while(n > 0){
            n = n - i;
            i++;
            k++;
        }
        int[] res = new int[k];
        i = 1;
        res[0] = k - 2;
        for(int j = 1; j <= res.length - 1; j++){
            if(j != n * (-1)) {
                res[i] = j;
                i++;
            }
        }
        for (int j = 0; j < res.length - 1; j++){
            System.out.printf(res[j] + ", ");
        }
    }
}

