package priorityQueue;

import listnode.OddEvenLinkedList;
import listnode.SwapNodesinPairs;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {

        ListNode list = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(7));

        ListNode[] arr = {list, list2, list3};

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode answers = mergeKSortedLists.mergeKLists(arr);

        while (answers != null) {
            System.out.println("answers.val = " + answers.val);
            answers = answers.next;
        }

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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val == o2.val) {
                    return 0;
                } else if (o1.val > o2.val) {
                    return 1;
                }else{
                    return -1;
                }
            }
        });
//        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
//            if (o1.val == o2.val) {
//                return 0;
//            } else if (o1.val > o2.val) {
//                return 1;
//            }else{
//                return -1;
//            }
//        });
        ListNode root = new ListNode(0);
        ListNode tail = root;
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

//        while(!pq.isEmpty()){
//            System.out.println("pq.poll().val = " + pq.poll().val);
//        }

//        맨처음에는 아래처럼만 insert 됨
//        pq.poll().val = 1
//        pq.poll().val = 1
//        pq.poll().val = 2

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
