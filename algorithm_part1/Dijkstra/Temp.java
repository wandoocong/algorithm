package algorithm_part1.Dijkstra;

import java.util.*;

public class Temp {

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}};

        Temp temp = new Temp();
        int solution = temp.solution(maps);
        System.out.println("solution = " + solution);
    }

    public class Position {
        int y;
        int x;
        int distance;

        public Position(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
    public void findDfs(int y, int x, int distance, int [][] maps) {

        if (x >= 0 && x < maps[1].length && y >= 0 && y < maps.length) {
            if (maps[y][x] == 1) {
                maps[y][x] = 0;
                distance++;
                pq.add(new Position(y, x, distance));
            }
        }
    }

    //1. PQ
    //PriorityQueue<Position> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
    PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingInt((a) -> a.distance));

    public int solution(int [][] maps) {

        pq.add(new Position(0, 0, 1));

        //2. answer dist Map
        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Position poll = pq.poll();
            dist.put(poll.y * 1000 + poll.x, poll.distance);

            findDfs(poll.y + 1, poll.x, poll.distance, maps);
            findDfs(poll.y - 1, poll.x, poll.distance, maps);
            findDfs(poll.y , poll.x+ 1, poll.distance, maps);
            findDfs(poll.y , poll.x-1, poll.distance, maps);
        }
        return dist.get((maps.length-1)* 1000 + (maps[1].length-1));
    }

    public static int findCheapestPrice(int n, int[][] times, int src, int dst, int k) {
        //1. graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        //2. PQ
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt((a) -> a.get(1)));
        pq.add(Arrays.asList(src, 0, 0));

        //3. answer
        while (!pq.isEmpty()) {
            List<Integer> poll = pq.poll();
            Integer dstP = poll.get(0);   //0
            Integer priceP = poll.get(1); //0
            Integer cnt = poll.get(2);    //0

            if (dstP == dst)
                return priceP;

            if (cnt <= k) {

                if (graph.containsKey(dstP)) {
                    for (Map.Entry<Integer, Integer> temp : graph.get(dstP).entrySet()) {
                        Integer key = temp.getKey();
                        Integer value = temp.getValue();
                        pq.add(Arrays.asList(key, value + priceP, cnt + 1));
                    }
                }
            }

        }

        return -1;
    }

    //1. graph
    //2. PQ
    //3. dist
    public static int networkDelayTime(int[][] times, int n, int k) {

        //1.
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        //2.
        //Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a1, a2)-> a1.getValue() - a2.getValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));

        //3.
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> poll = pq.poll();
            Integer key = poll.getKey(); //3
            Integer value = poll.getValue(); //0

            if (!dist.containsKey(key)) {
                dist.put(key, value);
                if (map.containsKey(key)) {                     // (1, 5) (2, 2) ...
                    for (Map.Entry<Integer, Integer> temp : map.get(key).entrySet()) {
                        Integer key1 = temp.getKey();
                        Integer value1 = temp.getValue();

                        pq.add(new AbstractMap.SimpleEntry(key1, value + value1));
                    }
                }
            }
        }
        System.out.println("dist = " + dist);
        return Collections.max(dist.values());
    }


}
