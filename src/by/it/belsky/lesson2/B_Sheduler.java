package by.it.belsky.lesson2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by misha on 08.01.2017.
 */
public class B_Sheduler {
    public static void main(String[] args) {
        B_Sheduler sheduler = new B_Sheduler();
        ArrayList<Event> list = new ArrayList<>();
        list.add(new Event(3, 7));
        list.add(new Event(1, 3));
        list.add(new Event(1, 4));
        list.add(new Event(2, 9));
        list.add(new Event(3, 10));
        list.add(new Event(0, 2));
        list.add(new Event(4, 7));
        list.add(new Event(0, 1));
        list.add(new Event(5, 9));
        list.add(new Event(3, 4));
        list.add(new Event(1, 2));
        list.add(new Event(9, 10));
        list.add(new Event(10, 11));

        System.out.println(sheduler.startRimes(list, 0, 10));


    }

    public static class Event {
        int start;
        int stop;

        Event(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public String toString() {
            return start + "-" + stop + " ";
        }
    }


    List<Event> startRimes(List<Event> list, int from, int to) {
        List<Event> result = new ArrayList<>();
        Comparator<Event> comparator = new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.stop - o2.stop;
            }
        };
        Collections.sort(list, comparator);
        int min = list.get(0).stop;
        result.add(list.get(0)); // здесь сразу добавили в решение событие с мин. правым концом
        for (int i = 0; i < list.size(); ) { // при i = 0 в цикле еще раз проверится отрезок 0-1 с самим собой
            // каждый раз, когда будет находится решение, то счетчик не будет увеличиваться на 1, а произойдет проверка
            // min и начала текущего отрезка и только потом (когда данное условие не выполнится), цикл перейдет к след. отрезку
            if (min <= list.get(i).start && list.get(i).stop<=to) {
                min = list.get(i).stop;
                result.add(list.get(i));
            } else
                i++;
        }

        return result;
    }
}