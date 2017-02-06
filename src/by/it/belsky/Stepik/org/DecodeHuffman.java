package by.it.belsky.Stepik.org;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DecodeHuffman {
    public static void main(String[] args) throws FileNotFoundException {
        DecodeHuffman instance = new DecodeHuffman();   // не принимало ответ , когда  в main был код
        // добавления данных  в map
        System.out.println(instance.decode());
    }

    String decode() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Integer count = scanner.nextInt(); // прочитает строку до пробела, и вернет прочитанное число (4- кол-во
        // неповторяющихся символов )
        Integer length = scanner.nextInt(); // прочитает дальше строку и вернет число(14 - длина кода)
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < count; ) {
            String s = scanner.nextLine();
            if (s.contains(": ")) {
                String[] x = s.split(": ");
                map.put(x[1], x[0]);
                i++;
            }
        }
        String s = scanner.next(); // считывает закодированную строку
        String code = "";
        String result = "";
        for (char ch : s.toCharArray()) {
            code = code + ch;
            if (map.containsKey(code.toString())) {
                result = result + map.get(code.toString());
                // code.delete(0,code.length()); - надо если  создаешь stringbuilder
                code = "";
            }
        }
        return result;
    }
}
