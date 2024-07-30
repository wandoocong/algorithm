package Dijkstra;

import java.util.*;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int[][] times = {{0, 1, 100}, {1, 2, 200}, {0, 2, 500}};
        int nodeCnt = 3;
        int src = 0, dst = 2, k = 0;

        int cheapestPrice = findCheapestPrice(nodeCnt, times, src, dst, k);
        System.out.println("cheapestPrice = " + cheapestPrice);
    }

    /*
     !!! 기존 문제와의 차이점 !!!
     기존에는 각 노드별 최단 시간을 구하는 문제였다면,
     이번에는 k개의 경유지 이내에 도착해야한다는 추가 제한사항이 존재
     */
    public static int findCheapestPrice(int n, int[][] times, int src, int dst, int k) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        // 정렬을 인덱스 1 기준으로 진행
        // 이번에는 pq 에 넣는값이 총 3개이므로, 그냥 List 로 넣자
        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
//        Queue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
//            @Override
//            public int compare(List<Integer> o1, List<Integer> o2) {
//                return o2.get(1) - o1.get(1);
//            }
//        });
        //Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        //pq.add(new AbstractMap.SimpleEntry<>(k, 0));

        // 출발지, 비용 0, 진행경로(거치는 경로 cnt) = 0
        pq.add(Arrays.asList(src, 0, 0));

        // 타임아웃을 방지하기 위해 한번 방문한 경로는 저장해두는 맵 선언
        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int u = cur.get(0);
            int price_u = cur.get(1);
            int k_visited = cur.get(2);

            if (u == dst)
                return price_u;

            // 목적지와 경유Cnt 값 넣기
            visited.put(u, k_visited);

            if (k_visited <= k) {

                k_visited++;

                // u 를 출발지로 하는 모든 경로 순회
                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        // 아직
                        if (!visited.containsKey(v.getKey()) || k_visited < visited.get(v.getKey())) {
                            int alt = price_u + v.getValue();
                                                // 도착지, 소요시간, 경유Cnt
                            pq.add(Arrays.asList(v.getKey(), alt, k_visited));
                        }
                    }
                }
            }


        }

        return -1;
    }

}
