package algorithm_part1.graph.graphPractice;

import java.util.*;

public class DfsPractice {

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

        //재귀 ver
        //List<Integer> discovered = recursiveDFS(1, r);

        //스택 반복 ver
        List<Integer> discovered2 = stackDFS(1);
        System.out.println("discovered2 = " + discovered2);

    }

    //재귀 ver
    // 1,2,5,6,7,3,4
    public static List<Integer> recursiveDFS(int v, List<Integer> discovered) {
        discovered.add(v);
        for (Integer w : graph.get(v)) {
            if (!discovered.contains(w)) {
                discovered = recursiveDFS(w, discovered);
            }
        }
        return discovered;
    }

    //스택을 이용한 반복 ver
    //1,4,3,5,7,6,2
    public static List<Integer> stackDFS(int v) {
        List<Integer> discoverd = new ArrayList<>();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.pop();

            if (!discoverd.contains(v)) {
                discoverd.add(v);
                for (Integer w : graph.get(v)) {
                    stack.push(w);
                }
            }
        }
        return discoverd;
    }

}
