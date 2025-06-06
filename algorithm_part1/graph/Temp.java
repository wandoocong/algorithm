package algorithm_part1.graph;

import java.util.*;

public class Temp {

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "BBB"}, {"BBB", "ICN"}, {"ICN", "AAA"}};

        String[] solutions = solutions(tickets);
        System.out.println("solutions = " + Arrays.toString(solutions));
    }

    public static String[] solutions(String[][] tickets) {
        // 그래프, pq
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] temp : tickets) {
            map.putIfAbsent(temp[0], new PriorityQueue<>());
            map.get(temp[0]).add(temp[1]);
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.add("ICN");
        List<String> answer = new ArrayList<>();

        //ICN ->AAA(끝)
        //ICN -> BBB -> ICN
        while (!deque.isEmpty()) {
            while (map.containsKey(deque.getFirst()) && !map.get(deque.getFirst()).isEmpty()) {
                deque.push(map.get(deque.getFirst()).poll());
            }
            answer.add(0, deque.pollFirst());
        }

        return answer.toArray(new String[0]);
    }
}