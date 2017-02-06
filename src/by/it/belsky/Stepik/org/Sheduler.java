package by.it.belsky.Stepik.org;

import java.util.*;

/**
 * Created by misha on 22.01.2017.
 */
public class Sheduler {
    public static class Event {
        int start;
        int stop;

        Event(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }
        @Override
        public String toString() {          // можно и так и так!!!!!!!!
            return start + " " + stop;
        }
    }
    public static void main(String[] args) {
        Sheduler instance = new Sheduler();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Event> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Event(scanner.nextInt(), scanner.nextInt()));
        }
        List<Integer> result = instance.sorting(list);
        System.out.println(result.size());
        for (int x : result)
            System.out.print(x+" ");
    }
    List <Integer> sorting(List<Event> list) {
        List <Integer> result = new ArrayList<>();
        Comparator<Event> comparator1 = new Comparator<Event>() {
            @Override
            public int compare(Event element1, Event element2) {
              //  if (element1.stop!=element2.stop) {
                    return element1.stop - element2.stop;   // можно и так и так!!!!!!!!
                }
           //     else  if (element1.stop==element2.stop)  {
              //      return element1.start - element2.start;
             //   }
           //     return 1;
           // }
        };
        Collections.sort(list, comparator1);
        int min = list.get(0).stop;
        result.add(min);
        for (int i = 0; i <list.size();   i++) {
            if (min >= list.get(i).start && !result.contains(min) ) { // если мин больше начала след отрезка, и
              //  result не содержит  min -чтобы второй раз не добавить одно и тоже число
                result.add(min);
                i++;
        }
            else
            if (min < list.get(i).start) {
                min = list.get(i).stop;
                result.add(min);  // если отрезки не будут пересекаться, то здесь , когда выполнится  условие, что
                // минимум будет меньше начала след. отрезка, min станет равным концу след. отрезка и СРАЗУ
                //ЖЕ добавиться в лист результатов
            }
        }

        return result;
    }
}
