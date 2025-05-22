package algorithm_part2.Greedy;

import java.util.*;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] peopleHeights = {{7, 0}, {4, 4}, {7, 1}, {6, 0}, {6, 2}, {5, 2}};
        int[][] ints = reconstructQueue(peopleHeights);
        System.out.println("ints[0][0] = " + ints[0][0]);
        System.out.println("ints[0][0] = " + ints[0][1]);

    }

    public static int[][] reconstructQueue(int[][] people) {

        // 중요
        // 여기서 형식을 int[][] 로하면 오류 발생 !!!!!!!!!!!!!!!!!!!!!!!!!
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            pq.add(person);
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            result.add(poll[1], poll);
        }
//        result.get(0)[0] .... 6
//        result.get(0)[1] .... 0 
        
        return result.toArray(new int[0][0]);
    }

}
