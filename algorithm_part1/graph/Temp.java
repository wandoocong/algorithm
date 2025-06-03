package algorithm_part1.graph;

import java.util.*;

public class Temp {

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] solutions = solutions(tickets);
        System.out.println("solutions = " + Arrays.toString(solutions));
    }

    public static String[] solutions(String[][] tickets) {
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for (String[] ticket : tickets) {
            fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            fromToMap.get(ticket[0]).add(ticket[1]);
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.push("ICN");
        List<String> answer = new ArrayList<>();

        while (!deque.isEmpty()) {
            while (fromToMap.containsKey(deque.getFirst()) && !fromToMap.get(deque.getFirst()).isEmpty()) {
                deque.push(fromToMap.get(deque.getFirst()).poll());
            }
            answer.add(0, deque.pop());
        }

        String[] array = answer.toArray(new String[0]);
        return array;
    }

}
