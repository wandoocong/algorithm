package algorithm_part1.graph;

import java.util.*;

public class BfsPractice {

    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(6, 7));
        graph.put(6, Arrays.asList());
        graph.put(7, Arrays.asList(3));

        List<Integer> r = new ArrayList<>();
        List<Integer> integers = QueueBFS(1);
        System.out.println("integers = " + integers);
    }

    public static List<Integer> QueueBFS(int start_v) {

        //결과값 저장
        List<Integer> discovered = new ArrayList<>();

        //시작 노드 삽입
        discovered.add(start_v);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start_v);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int w : graph.get(v)) {
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.add(w);
                }
            }
        }
        return discovered;
    }
}
