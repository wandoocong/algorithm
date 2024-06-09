package listnode;

import java.util.*;

public class PalindromeLinkedList {

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

    public static void main(String[] args) {
/*
//      ListNode 무식 선언
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode head = a;
        while (head != null) {
            System.out.println("list = " + head.val);
            head = head.next;
        }
*/
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

        System.out.println("is palindrome? = " + palindromeLinkedList.isPalindrome(listNode));
        System.out.println("is palindromeDeque? = " + palindromeLinkedList.isPalindromeDeque(listNode));
        System.out.println("is palindromeRunnable? = " + palindromeLinkedList.isPalindromeRunnable(listNode));

    }

    public Boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        //연결 리스트를 스택에 삽입
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public Boolean isPalindromeDeque(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();

        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        while (!deque.isEmpty() && deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }

        return true;
    }

    public Boolean isPalindromeRunnable(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        // 빠른러너가 끝날때 까지 느린 러너도 함께 진행
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 홀수 개일 때 느린 러너는 한칸더 앞으로 가야해
        if (fast != null) {
            slow = slow.next;
        }

        ListNode rev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }

        while (rev != null) {
            if (rev.val != head.val) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }

        return true;
    }
}
