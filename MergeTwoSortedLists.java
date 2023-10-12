public class MergeTwoSortedLists {
        public static void main(String[] args) {
                ListNode l1_node3 = new ListNode(4, null);
                ListNode l1_node2 = new ListNode(2, l1_node3);
                ListNode l1_head = new ListNode(1, l1_node2);

                ListNode l2_node3 = new ListNode(4, null);
                ListNode l2_node2 = new ListNode(3, l2_node3);
                ListNode l2_head = new ListNode(1, l2_node2);

                mergeTwoLists(l1_head, l2_head);
        }
        /*
        pick element from each list compare, and one of them to output and move forward
        if any of the list reaches null add rest of the array to output and return
        O(n)
         */

        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                ListNode output = new ListNode(-1, null);
                ListNode current = output;

                while (list1 != null || list2 != null) {
                        if (list1 == null) {
                                current.next = list2;
                                return output.next;
                        } else if (list2 == null) {
                                current.next = list1;
                                return output.next;
                        } else if (list1.val <= list2.val) {
                                current.next = list1;
                                list1 = list1.next;
                        } else {
                                current.next = list2;
                                list2 = list2.next;
                        }
                        current = current.next;
                }
                return output.next;
        }
}
