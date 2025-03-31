package graph;

import java.util.*;

public class Temp {

    public static void main(String[] args) {

        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        String[] solutions = solutions(tickets);
        System.out.println("solutions = " + Arrays.toString(solutions));
    }

    public static String[] solutions(String[][] tickets) {

        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
        Deque<String> stack = new ArrayDeque<>();
        List<String> results = new ArrayList<>();

        for (String[] ticket : tickets) {
            if (!fromToMap.containsKey(ticket[0])) {
                fromToMap.put(ticket[0], new PriorityQueue<>());
            }
            fromToMap.get(ticket[0]).add(ticket[1]);
        }

        stack.push("ICN");
        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                stack.push(fromToMap.get(stack.getFirst()).poll());
            }
            results.add(0, stack.poll());
        }

        return results.toArray(new String[0]);
    }
}
