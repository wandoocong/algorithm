package listnode;

import java.util.List;

public class ReverseLinkedList {

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
    public static void main(String[] args) {

        System.out.println("반복문 Version1 ");
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode reverseNode = reverseLinkedList.reverse(list1);

        while (reverseNode != null) {
            System.out.println(reverseNode.val);
            reverseNode = reverseNode.next;
        }

        //todo
        // 질문 .... 왜 여기서 list1 은 1 하나만 남지??
        // list1 은 건든적이 없는데??
        while (list1 != null) {
            System.out.println(list1.val);
            list1 = list1.next;
        }

        System.out.println("===========================================");

        System.out.println("재귀 Version2 ");

        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversSelfNode = reverseLinkedList.reverseSelfVersion(list2, null);
        while (reversSelfNode != null) {
            System.out.println(reversSelfNode.val);
            reversSelfNode = reversSelfNode.next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode rev = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = rev;
            rev = node;
            node = next;
        }
        return rev;
    }

    // 내생각에 재귀는 첫번째로 null 에 의한 탈출 조건을 생각해야돼
    // 그리고 재귀 방식은 크게 두종류야
    // 1. 팡팡팡팡대입 return
    // 2. 단순 반복 호출 return
    public ListNode reverseSelfVersion(ListNode node, ListNode prev) {

        if (node == null)
            return prev;

        ListNode next = node.next;
        node.next = prev;

        return reverseSelfVersion(next, node);
    }
}
