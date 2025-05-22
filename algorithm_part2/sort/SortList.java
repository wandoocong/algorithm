package algorithm_part2.sort;

public class SortList {
    public static void main(String[] args) {
        ListNode list = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode list1 = sortList(list);

        while (list1 != null) {
            System.out.println("list1 = " + list1.val);
            list1 = list1.next;
        }
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        l1.next = mergeTwoList(l1.next, l2);
        return l1;
    }
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        //1. 하나의 연결된 list 값을 반띵한다, head, slow 로 나눈다
        // head = -1 5
        // slow =  3 4 0
        ListNode half = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        half.next = null;

        //2. 각각 최소 단위로 나눠지고, sorted 된 상태로 다시 붙인다 -> ** mergeTwoList 에 의해서 정렬됨.
        ListNode l1 = sortList(head); //-1 5
        ListNode l2 = sortList(slow); // 0 3 4

        return mergeTwoList(l1, l2);
    }

    private static class ListNode {
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
}
