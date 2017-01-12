package by.it.belsky.lesson3;





import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by misha on 11.01.2017.
 */
public class B_Huffman {
    public static void main(String[] args) throws FileNotFoundException {
        B_Huffman instance = new B_Huffman();
        File file = new File(System.getProperty("user.dir") + "/src/" + "/by/it/belsky/lesson3/EncodeHuffman.txt");

            System.out.println(instance.decode(file));

        }

        //System.out.println(instance.decode(file));



    String decode(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Integer count = scanner.nextInt(); // прочитает строку до пробела, и вернет прочитанное число (4- кол-во
        // неповторяющихся символов )
        Integer length = scanner.nextInt(); // прочитает дальше строку и вернет число(14 - длина кода)
       Map<String, String> map = new HashMap<>();
        for (int i = 0; i<count;) {
            String s = scanner.nextLine();
            if (s.contains(": ")) {
                String [] x = s.split(": ");
                map.put(x[0], x[1]);
                i++;
                }
            }


                String s = scanner.next();
        String code = "";
        String result = "";
        for (char ch : s.toCharArray()) {
           code = code + ch;
            if (map.containsKey(code.toString())) {
                result = result + map.get(code.toString());
                //code.delete(0,code.length());
                code ="";
            }
        }
        return result;
    }
}
