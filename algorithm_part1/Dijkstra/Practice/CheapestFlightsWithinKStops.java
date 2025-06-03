package algorithm_part1.Dijkstra.Practice;

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

        // 출발지와 동일한 목적지이므로 비용은 0.
        // 목적지, 비용, 진행경로(거치는 경로 cnt) = 0
        pq.add(Arrays.asList(src, 0, 0));

        // 도착지, 진행경로수
        // 도착지까지의 진행경로 저장
        Map<Integer, Integer> visitHist = new HashMap<>();

        while (!pq.isEmpty()) {
            List<Integer> poll = pq.poll();
            Integer u = poll.get(0); //도착지
            Integer value = poll.get(1); //비용
            Integer cnt = poll.get(2); //경로수

            // 같으면 바로 최소값이라는것을 보장할수 있는 이유는
            // pq 에서 추출되기 때문
            if (u == dst) {
                return value;
            }

            // 목적지와 경로수 저장
            visitHist.put(u, cnt);

                // 문제에서 지정해준 k 까지는 경로수를 채워야함
                if (cnt <= k) {
                    cnt++;
                    if (graph.containsKey(u)) {
                        for(Map.Entry <Integer, Integer> v : graph.get(u).entrySet()){

                            //방문이력이 없거나, 있는데 이력 테이블에 저장된 경로수보다 더 작은 경로수라면 기회를 줘야함
                            if(!visitHist.containsKey(v.getKey()) || cnt < visitHist.get(v.getKey()))
                                pq.add(Arrays.asList(v.getKey(), (v.getValue() + value), cnt));
                        }
                    }
                }
        }

        return -1;
    }

}
