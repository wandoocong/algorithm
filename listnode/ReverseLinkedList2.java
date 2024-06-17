package listnode;

public class ReverseLinkedList2 {

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
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        int left = 2, right = 5;

        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        ListNode listNode = reverseLinkedList2.reverseBetween(list1, left, right);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode start = head;
        for (int i = 0; i < left-2; i++) {
            start = start.next;
        }
        ListNode end = start.next;

        // todo
        // 이게 순서가 중요하네....
        // 순서가 잘못 바뀌면 next 의 값등에 변화가 생겨서 꼬여버리네.....
        // 실시간 파악은 쉽지 않겠는데........
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }

        return start;
    }
}
