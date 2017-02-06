package by.it.belsky.Stepik.org;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by misha on 01.02.2017.
 */
public class GreedyKnapsack {
    public static class Item implements Comparable<Item> {
        double cost;
        double weight;
        Item (double cost, double weight) {
            this.cost = cost;
            this.weight = weight;
        }
        @Override
        public int compareTo(Item o) {
            double r1 = cost/weight;
            double r2 = o.cost/o.weight;

            return Double.compare(r2, r1);

        }
        @Override
        public String toString() {
            return "["+cost+" : "+weight+"]";
        }
    }
    double price () {
        Scanner scanner = new Scanner(System.in);
        int numberOfItems = scanner.nextInt();
        int W = scanner.nextInt();
        Item item [] = new Item[numberOfItems];
        for (int i = 0; i<numberOfItems; i++) {
            int cost = scanner.nextInt();
            int weight = scanner.nextInt();
            item [i] = new Item(cost, weight);
        }
        double result = 0;
        Arrays.sort(item);
        for (Item x : item) {
            System.out.println((double) x.cost/x.weight);
        }
        for ( Item x : item) {
            if (x.weight<=W) {
                result += x.cost; // добавляем стоимость к искомой
                W -= (double) x.weight; //  вычитаем из общей массы положенный предмет
            }
            else {
                result += x.cost / x.weight * W;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        GreedyKnapsack instance = new GreedyKnapsack();
        double result = instance.price();
        System.out.printf("%.3f",result);
    }
}
