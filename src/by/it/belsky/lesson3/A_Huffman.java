package by.it.belsky.lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by misha on 10.01.2017.
 */
public class A_Huffman {
    public static void main(String[] args) throws FileNotFoundException {
        A_Huffman instance = new A_Huffman();
        String root = System.getProperty("user.dir") + "/src/";
        File f = new File(root + "/by/it/belsky/lesson3/Huffman.txt");
      String result =  instance.encode(f);
        System.out.println(codes.size()+" "+result.toCharArray().length);
        for (Map.Entry<Character, String> map : codes.entrySet())
            System.out.println(map.getKey() +": " +map.getValue());
        System.out.println(result);
    }

    public abstract class Node implements Comparable<Node> {
        private final int frequence;

        Node(int frequence) {
            this.frequence = frequence;
        }

        abstract void FillCodes(String code);

        public int compareTo(Node node) {
            return Integer.compare(frequence, node.frequence);
        }
    }

    private class InternalNode extends Node {

        Node left;
        Node right;

        InternalNode(Node left, Node right) {
            super(left.frequence + right.frequence);
            this.left = left;
            this.right = right;
        }

        @Override
        void FillCodes(String code) {
            left.FillCodes(code + "0");
            right.FillCodes(code + "1");

        }

        @Override
        public String toString() {
            return super.frequence + ""; // для проверки работы
        }
    }

    private class LeafNode extends Node {  // когда создаем очередь из элементов Hashmap,в него ложим
        // узлы (листья, используя конструктор данного класса)
        char symbol;

        LeafNode(char symbol, int frequence) {
            super(frequence);
            this.symbol = symbol;
        }

        @Override
        void FillCodes(String code) {
            codes.put(symbol, code);
        }

        @Override
        public String toString() {
            return symbol + ":" + super.frequence; // просто для проверки работы
        }
    }

    static private Map<Character, String> codes = new TreeMap<>();

    String encode(File file) throws FileNotFoundException {
        //прочитаем строку для кодирования из тестового файла
        Scanner scanner = new Scanner(file);
        String s = scanner.next();
        Map<Character, Integer> count = new HashMap<>();
        char x[] = s.toCharArray();
        for (char element : x) {
            if (count.containsKey(element)) {
                count.put(element, count.get(element) + 1);
            } else count.put(element, 1);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> element : count.entrySet()) {
            priorityQueue.add(new LeafNode(element.getKey(), element.getValue()));
        }

        while (priorityQueue.size() != 1) {
            priorityQueue.add(new InternalNode(priorityQueue.poll(), priorityQueue.poll()));
        }
        Node root = priorityQueue.poll();// берем последний элемент , в нем хранится только частота
        if (count.size()!=1) {
            root.FillCodes("");
        }
        String finalcode = "";
        for (char symbol : s.toCharArray())

            finalcode = finalcode + codes.get(symbol);

        return finalcode;

    }


}
