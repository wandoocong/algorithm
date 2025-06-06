package algorithm_part1.graph;

import java.util.*;

public class Reconstruct_itinerary_Programmers {

    public static void main(String[] args) {


//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "BBB"}, {"BBB", "ICN"}, {"ICN", "AAA"}};

        String[] solutions = solutions(tickets);
        System.out.println("solutions = " + Arrays.toString(solutions));
    }

    public static String[] solutions(String[][] tickets) {

        //1. graph -> PQ 생성
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for (String[] ticket : tickets) {
            fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            fromToMap.get(ticket[0]).add(ticket[1]);
        }
        List<String> answer = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("ICN");

        //2. stack 에 push
        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                stack.push(fromToMap.get(stack.getFirst()).poll());
            }
            answer.add(0, stack.pop());
        }
        return answer.toArray(new String[0]);
    }
}
