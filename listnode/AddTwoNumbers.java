package listnode;

import java.util.List;

public class AddTwoNumbers {

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
        ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(2)));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        //노드 reverse
        ListNode listNode = addTwoNumbers.reverseList(list1);
        ListNode listNode2 = addTwoNumbers.reverseList(list2);

        //정수변환
        Integer anInt = addTwoNumbers.toInt(listNode);
        Integer anInt2 = addTwoNumbers.toInt(listNode2);

        Integer answerInt = anInt + anInt2;
        System.out.println("anInt = " + (answerInt));


        //노드 만들기
        //1. 역방향
        ListNode reversedLinkedList = addTwoNumbers.toReversedLinkedList(answerInt);
        while (reversedLinkedList != null) {
            System.out.println("reversedLinkedList.val = " + reversedLinkedList.val);
            reversedLinkedList = reversedLinkedList.next;
        }

        //2. 정방향
        ListNode linkedList = addTwoNumbers.toLinkedList(answerInt);
        while (linkedList != null) {
            System.out.println("linkedList.val = " + linkedList.val);
            linkedList = linkedList.next;
        }


    }

    // ListNode 뒤집기
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public Integer toInt(ListNode head) {
        String str = "";

        while (head != null) {
            str += head.val;
            head = head.next;
        }
        return Integer.valueOf(str);
    }

    //역방향
    public ListNode toReversedLinkedList(Integer val) {

        ListNode prev = null, node = null;
        for (char c : String.valueOf(val).toCharArray()) {
            node = new ListNode(c - '0');
            node.next = prev;
            prev = node;
        }
        return prev;
    }
    //정방향
    public ListNode toLinkedList(Integer val) {
        ListNode head = null, newNode = null, temp = null;

        for (char c : String.valueOf(val).toCharArray()) {
            newNode = new ListNode(c - '0');
            if (head == null) {
                head = newNode;
            }else{
                temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        //todo
        // 33333temp 에 신규로 이어도, 원본까지 바뀌네?
        return head;
    }

}
