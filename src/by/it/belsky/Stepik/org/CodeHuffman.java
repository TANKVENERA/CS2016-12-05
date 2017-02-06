package by.it.belsky.Stepik.org;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by misha on 25.01.2017.
 */
public class CodeHuffman {
    public static void main(String[] args) {
        CodeHuffman instanse = new CodeHuffman();
        String result =  instanse.fillcodes();
       System.out.println(codes.size()+" "+ result.toCharArray().length);
        for (Map.Entry<Character, String> x : codes.entrySet())
        System.out.println(x.getKey()+": "+x.getValue());
        System.out.println(result);

    }
    public abstract class Node implements Comparable<Node>  {
        public final int frequence ;
        public Node (int frequence) {
            this.frequence = frequence;
        }
        abstract  void Fillcodes (String code);
        @Override
        public int compareTo(Node node) {
            return Integer.compare(frequence, node.frequence); // без него  - элементы в Map будут в произвольном порядке
        }

    }
    public class InternalNode extends Node {
        Node left;
        Node right;
        public InternalNode (Node left, Node right) {
            super(left.frequence+right.frequence);
            this.left = left;
            this.right = right;
        }
        @Override
        void Fillcodes(String code) {
            left.Fillcodes(code+"0");
            right.Fillcodes(code+"1");
        }

        @Override
        public String toString() {
            return super.frequence+ "";
        }
    }
    public class LeafNode extends Node {
        char symbol;

        public LeafNode(char symbol, int frequence) {
            super(frequence);
            this.symbol = symbol;
        }
        @Override
        void Fillcodes(String code) {
           codes.put(symbol, code);
        }

        @Override
        public String toString() {
            return symbol+ ":"+ super.frequence;
        }
    }
    public static Map<Character, String> codes = new TreeMap<>();
    public String fillcodes () {
        Map<Character, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char [] symbol = line.toCharArray();
        for (char x : symbol) {
            if (map.containsKey(x))
                map.put(x, map.get(x)+1);
            else
                map.put(x, 1);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> element : map.entrySet()) {
            priorityQueue.add(new LeafNode(element.getKey(), element.getValue()));
        }
        while (priorityQueue.size()!=1) {
            priorityQueue.add(new InternalNode(priorityQueue.poll(), priorityQueue.poll())); // останется один
            // элемент - родитель с общей частотой
        }

        Node root = priorityQueue.poll();
        if (map.size()==1) {    // если  код из 1-го символа , то сразу будет ноль и все
            root.Fillcodes("0");
        }
        else {
            root.Fillcodes("");
        }
            String finalcode = "";
            for (char x : symbol) {
                finalcode = finalcode + codes.get(x);
        }
        return finalcode;
    }
}
