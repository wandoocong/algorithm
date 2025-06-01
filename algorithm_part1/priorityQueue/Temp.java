package algorithm_part1.priorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Temp {

    public static void main(String[] args) {

        String [] operation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "I 333", "I 8", "I 7", "D -1"};
        int[] solution = solution(operation);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(String[] operations) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String temp : operations) {
            String[] s = temp.split(" ", 2);

            if (s[0].equals("I")) {
                minHeap.add(Integer.valueOf(s[1]));
                maxHeap.add(Integer.valueOf(s[1]));
            } else if (s[0].equals("D")) {
                if (s[1].equals("1")) {
                    minHeap.remove(maxHeap.poll());
                } else {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        return new int[]{maxHeap.poll(), minHeap.poll()};

    }
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int temp : nums) {
            pq.add(temp);
        }

        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer = pq.poll();
        }
        return answer;
    }

    public static int solution(int[] scovile, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        for (int temp : scovile) {
            pq.add(temp);
        }

        while (!pq.isEmpty() && pq.size()>1) {
            Integer poll1 = pq.poll(); //1
            Integer poll2 = pq.poll(); //2
                    // 1, 2, 3, 9
            int sco = poll1 + (poll2 * 2);
            answer++;
            if ( sco >= K) {
                return answer;
            }else{
                pq.add(sco);
            }
        }

        return -1;
    }

    private static class Points {
        double distance;
        int[] point;

        public Points(double distance, int[] point) {
            this.point = point;
            this.distance = distance;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {

        /*
        예: a.distance = 1.2, b.distance = 1.8이면 (int)(1.2 - 1.8)은 (int)(-0.6) → 0이 됩니다.
        즉, 실제로는 다르지만 같다고 인식합니다.
        정렬의 정확성에 문제가 생길 수 있습니다.
        */
//        PriorityQueue<Points> pq = new PriorityQueue<>((a, b) -> (int) (a.distance - b.distance));
        PriorityQueue<Points> pq = new PriorityQueue<>(Comparator.comparingDouble((a -> a.distance)));
        for (int[] temp : points) {
            double distemp = Math.sqrt(temp[0] * temp[0] + temp[1] * temp[1]);
            Points points1 = new Points(distemp, temp);
            pq.add(points1);
        }

        int [][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().point;
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val == o2.val)
                    return 0;
                else if (o1.val > o2.val) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        ListNode root = new ListNode(0);
        ListNode tail = root;

        for (ListNode node : lists) {
            if(node != null)
                pq.add(node);
        }

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null) {
                pq.add(tail.next);
            }
        }

        return root.next;
    }

}
