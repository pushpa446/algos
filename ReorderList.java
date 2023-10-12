public class ReorderList {
        public static void main(String[] args) {
                ListNode node4 = new ListNode(4, null);
                ListNode node3 = new ListNode(3, node4);
                ListNode node2 = new ListNode(2, node3);
                ListNode head = new ListNode(1, node2);
                reorderList(head);
        }

        /*
        reach mid-pointer(slow fast approach to reach mid), and reverse the second part
        now start from head keep pointing elements alternatively
        */

        public static void reorderList(ListNode head) {
                ListNode first = head;
                ListNode slow = head, fast = head.next;
                while(fast != null && fast.next != null){
                        slow = slow.next;
                        fast = fast.next.next;
                }
                ListNode second =  slow.next;
                slow.next = null;
                ListNode prev = null;
                while (second != null){
                        ListNode temp = second.next;
                        second.next = prev;
                        prev = second;
                        second = temp;
                }
                second = prev;
                while (first != null && second != null){
                        ListNode temp1 = first.next;
                        ListNode temp2 = second.next;
                        first.next = second;
                        second.next = temp1;
                        first = temp1;
                        second = temp2;
                }
        }
}
