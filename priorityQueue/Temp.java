package priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Temp {

    private static class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static class Point{
        double distance;
        int[] point;

        public Point(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public static void main(String[] args) {
        /*ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(7));

        ListNode[] arr = {listNode1, listNode2, listNode3};
        ListNode listNode = mergeKLists(arr);
        while (listNode != null) {
            System.out.println("listNode = " + listNode.val);
            listNode = listNode.next;
        }*/

        /*int[][] arr = {{3, 3}, {6, -1}, {-2, 4}};
        int[][] ints = kClosest(arr, 2);
//        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints[0][1]));
        System.out.println("Arrays.toString(ints) = " + (ints[0][1]));*/

        int[] scovile = {1, 2, 3, 9, 10, 12};
        int solution = solution(scovile, 7);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[] scovile, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : scovile) {
            pq.add(a);
        }

        int answer = 1;
        while (pq.size() > 2) {
            pq.add(pq.poll() + (pq.poll() * 2));
            if (pq.peek() > K) {
                return answer;
            }
            answer++;
        }
        return answer;
    }
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));

        for (int[] point : points) {
            double distance = Math.sqrt((long) point[0] * point[0] + (long) point[1] * point[1]);
            queue.add(new Point(distance, point));
        }

        int[][] results = new int[k][];
        for (int i = 0; i < k; i++) {
            results[i] = queue.poll().point;
            System.out.println("results = " + results[i]);
        }

        return results;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val > o2.val){
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (ListNode list : lists) {
            queue.add(list);
        }

        ListNode root = new ListNode(0);
        ListNode tail = root;

        while (!queue.isEmpty()) {

            ListNode poll = queue.poll();
            tail.next = poll;
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return root.next;
    }
}
