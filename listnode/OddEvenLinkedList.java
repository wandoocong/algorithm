package listnode;

import java.util.List;

public class OddEvenLinkedList {

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
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

        ListNode listNode1 = oddEvenLinkedList.oddEvenList(listNode);
        while (listNode1 != null) {
            System.out.println("listNode~~~.val = " + listNode1.val);
            listNode1 = listNode1.next;
        }

//        ListNode listNode1 = oddEvenLinkedList.oddEvenWanSoo(listNode);
//        while (listNode1 != null) {
//            System.out.println("listNode1.val = " + listNode1.val);
//            listNode1 = listNode1.next;
//        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        // 홀수 노드 마지막을 짝수 노드와 연결
        odd.next = evenHead;
        return head;
    }


    public ListNode oddEvenWanSoo(ListNode Head) {
        ListNode odd = null, even = null ;
        //순차적 이동하며 new node 에 추가해주자
        while (Head != null) {
            // 신규 값으로 하나 생성
            ListNode newOne = new ListNode(Head.val);

            if (newOne.val % 2 == 0) {
                if (even == null) {
                    even = newOne;
                }else{
                    ListNode temp = even;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = newOne;
                }
            } else {
                if (odd == null) {
                    odd = newOne;
                }else{
                    ListNode temp = odd;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = newOne;
                }
            }
            Head = Head.next;
        }
        ListNode temp = odd;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = even;

        return odd;
    }

}
