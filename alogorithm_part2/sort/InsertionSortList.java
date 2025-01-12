package alogorithm_part2.sort;

import java.util.List;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(5, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode listNode1 = insertionSortList(listNode);

        while (listNode1 != null) {
            System.out.println("list1 = " + listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {

        ListNode parent = new ListNode();
        ListNode p = parent;

        while (head != null) {
            // 정렬 끝낸 p의 다음값이 정렬해야하는 대상 head 값보다 작다면, 계속 뒤로 이동
            // --> head 를 넣을 직전값까지 next 이동을 해야함
            while(p.next != null && p.next.val < head.val) {
                p = p.next;
            }

            ListNode pNext = p.next;
            ListNode headNext = head.next;
            p.next = head;
            head.next = pNext;
            head = headNext;

            //만약 p값이 대상 head 값 보다 크면,
            //다시 그앞쪽에 삽입하는위치를 확인해야하므로 처음 parent 로 이동
            if(head != null && p.val > head.val)
                p = parent;
        }
        return parent.next;
    }

    public static class ListNode {
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
