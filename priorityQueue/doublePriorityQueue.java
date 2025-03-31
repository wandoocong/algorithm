package priorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class doublePriorityQueue {

    public static void main(String[] args) {
        String [] operation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "I 333", "I 8", "I 7", "D -1"};
        int[] solution = solution(operation);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String str : operations) {
            String[] s = str.split(" ");
            if ("I".equals(s[0])) {
                minHeap.add(Integer.valueOf(s[1]));
                maxHeap.add(Integer.valueOf(s[1]));
            } else if ("D".equals(s[0])) {
                if ("1".equals(s[1])) {
                    minHeap.remove(maxHeap.poll());
                } else {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        Integer maxN = maxHeap.poll();
        Integer minN = minHeap.poll();


        return new int[]{(maxN==null) ? 0 : maxN, (minN==null) ? 0 : minN};
    }
}
