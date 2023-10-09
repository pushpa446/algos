public class ReverseLinkedList {
        public static void main(String[] args) {
                ListNode node5 = new ListNode(4, null);
                ListNode node3 = new ListNode(3, node5);
                ListNode node2 = new ListNode(2, node3);
                ListNode head = new ListNode(1, node2);
                reverseList(head);

        }

        /*
        use two pointer approach,
        start prev = null, current = head
         */

        public static ListNode reverseList(ListNode head) {
                ListNode prev = null;
                ListNode current = head;
                while (current != null) {
                        ListNode temp = current.next;
                        current.next = prev;
                        prev = current;
                        current = temp;
                }
                return prev;
        }

        public static class ListNode {
                int val;
                ListNode next;

                ListNode() {
                }

                ListNode(int val) {
                        this.val = val;
                }

                ListNode(int val, ListNode next) {
                        this.val = val;
                        this.next = next;
                }
        }
}
