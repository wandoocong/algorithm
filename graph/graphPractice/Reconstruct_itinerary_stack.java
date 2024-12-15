package graph.graphPractice;

import java.util.*;

public class Reconstruct_itinerary_stack {

    public static void main(String[] args) {
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
        List<List<String>> tickets = new ArrayList<>();

        List<String> str1 = new ArrayList<>(Arrays.asList("JFK", "ICN"));
        List<String> str2 = new ArrayList<>(Arrays.asList("JFK", "ATL"));
        List<String> str3 = new ArrayList<>(Arrays.asList("ICN", "ATL"));
        List<String> str4 = new ArrayList<>(Arrays.asList("ATL", "ICN"));
        List<String> str5 = new ArrayList<>(Arrays.asList("ATL", "JFK"));


        tickets.add(str1);
        tickets.add(str2);
        tickets.add(str3);
        tickets.add(str4);
        tickets.add(str5);
        System.out.println("tickets = " + tickets);

        List<String> itinerary = findItinerary(tickets);
        System.out.println("itinerary = " + itinerary);

    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> fromToMap =new HashMap<>();

        for (List<String> ticket : tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> results = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("JFK");

        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                stack.push(fromToMap.get(stack.getFirst()).poll());
            }
            results.add(0, stack.pop());
        }
        return results;
    }


}

