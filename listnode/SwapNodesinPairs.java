package listnode;

public class SwapNodesinPairs {

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


    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        SwapNodesinPairs swapNodesinPairs = new SwapNodesinPairs();
        ListNode listNode = swapNodesinPairs.swapPairs(list);
        while (listNode != null) {
            System.out.println("listNode.val = " + listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode node = head;

        while(node != null && node.next != null){
            int temp;
            temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;

            node = node.next.next;
        }
        return head;
    }
}
