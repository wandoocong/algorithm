package algorithm_part1.Dijkstra.Practice;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {

        int[][] time = {{3, 1, 5}, {3, 2, 2}, {2, 1, 2}, {3, 4, 1}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}, {7, 8, 1}, {8, 1, 1}};
        //전체 노드수
        int nodeCnt = 8;
        //시작 노드
        int startNode = 3;
        int answer = networkDelayTime(time, nodeCnt, startNode);
        System.out.println("answer = " + answer);

    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        // #################################1. algorithm_part1.graph 만들기 ###############################
        // 출발지, 도착지, 소요시간
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));

        // 도착지, 소요시간 최종결과를 저장하는 변수
        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> poll = pq.poll();
            Integer key = poll.getKey();
            Integer value = poll.getValue();

            if (!dist.containsKey(key)) {
                dist.put(key, value);

                if (graph.containsKey(key)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(key).entrySet()) {
                        Integer alt = value + v.getValue();
                        pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
                    }
                }
            }
        }
        if (dist.size() == n) {
            return Collections.max(dist.values());
        }
        return -1;
    }
}
