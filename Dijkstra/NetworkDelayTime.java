package Dijkstra;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {

        int[][] time = {{3, 1, 5}, {3, 2, 2}, {2, 1, 2}, {3, 4, 1}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}, {7, 8, 1}, {8, 1, 1}};
        int nodeCnt = 8, startNode = 3;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int answer = networkDelayTime.networkDelayTime(time, nodeCnt, startNode);
        System.out.println("answer = " + answer);

    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // #################################1. graph 만들기 ###############################
        // 출발지, 도착지, 소요시간
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            // 값이 없으면 HashMap 생성
            graph.putIfAbsent(time[0], new HashMap<>());
            // 출발지에 (도착지, 소요시간) 추가
            graph.get(time[0]).put(time[1], time[2]);
        }

        // ##################2. pq 만들고, 도착지-소요시간 최종결과 Map 생성 ###################
        // 도착지, 소요시간값을 우선순위 큐에 넣고, 정렬기준은 소요시간으로 한다.
        // Map.Entry 로 선언하는 이유는 추후 값을 꺼낼때
        //              map.getKey, map.getValue 를 바로 처리하려고
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0)); //출발지는 k 이며, 소요시간은 출발지이므로 0

        // 도착지, 소요시간 최종결과를 저장하는 변수
        Map<Integer, Integer> dist = new HashMap<>();

        // ##################3. 비즈니스 로직  #############################################
        // 3. 최소 소요시간 기준으로 dist 에 도착지, 최소소요시간 결과 넣기
        // 3-1. dist 도착지를 출발지로 하는 값들의 도착지, 소요시간을 pq 에 삽입
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> cur = pq.poll();
            int u = cur.getKey(); //도착지
            int dist_u = cur.getValue(); //소요시간

            // u 지점에 대한 소요시간 처리가 계산되지 않았다면, 처리시작
            if (!dist.containsKey(u)) {
                dist.put(u, dist_u);
                // u 를 출발지로 한 모든 경로 조회 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        int alt = dist_u + v.getValue();
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
