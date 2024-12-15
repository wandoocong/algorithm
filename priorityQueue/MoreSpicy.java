package priorityQueue;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scovile = {1, 2, 3, 9, 10, 12};
        int solution = solution(scovile, 7);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[] scovile, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scovile) {
            pq.add(s);
        }

        int answer = 1;
        while (pq.size() >= 2) {
            pq.add(pq.poll() + (pq.poll() * 2));
            if (pq.peek() >= K) {
                return answer;
            }
            answer++;
        }

        return -1;
    }
}
