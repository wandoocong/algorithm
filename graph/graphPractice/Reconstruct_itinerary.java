package graph.graphPractice;

import java.util.*;

public class Reconstruct_itinerary {

    public static void main(String[] args) {

        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
        List<List<String>> tickets = new ArrayList<>();

        List<String> str1 = new ArrayList<>(Arrays.asList("MUC", "ICN"));
        List<String> str2 = new ArrayList<>(Arrays.asList("JFK", "MUC"));
        List<String> str3 = new ArrayList<>(Arrays.asList("SFO", "SJC"));
        List<String> str4 = new ArrayList<>(Arrays.asList("ICN", "SFO"));
        tickets.add(str1);
        tickets.add(str2);
        tickets.add(str3);
        tickets.add(str4);
        System.out.println("tickets = " + tickets);

        for (List<String> ticket : tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> answers = new ArrayList<>();

        dfs(answers, fromToMap, "JFK");

        System.out.println("answers = " + answers);
    }

    public static void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String from) {

        // fromToMap 에 특정 Key 값을 갖고 있고, 해당 value 값이 비어있지 않을때
        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            dfs(results, fromToMap, fromToMap.get(from).poll());
        }
        // 앞에다 추가
        results.add(0, from);
    }
}
