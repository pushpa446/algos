package basics;

import java.util.ArrayList;

public class SingleLinkedList {
        private Node head;
        private Node tail;

        public SingleLinkedList() {

        }

        public int get(int index) {
                int count = 0;
                Node temp = head;
                while (temp != null) {
                        if (count == index) {
                                return temp.value;
                        }
                        temp = temp.next;
                        count++;
                }
                return -1;
        }

        public void insertHead(int val) {
                if (head == null) {
                        head = new Node(val, null);
                        tail = head;
                } else {
                        Node temp = new Node(val, head);
                        head = temp;
                }
        }

        public void insertTail(int val) {
                Node temp = new Node(val, null);
                if (tail == null) {
                        tail = temp;
                        head = tail;
                } else {
                        tail.next = temp;
                        tail = temp;
                }
        }

        public boolean remove(int index) {
                if (head == null) {
                        return false;
                }
                if (index == 0) {
                        head = head.next;
                        return true;
                }
                int count = 1;
                Node temp = head;
                while (temp != null) {
                        if (count == index) {
                                if (temp.next != null) {
                                        if (temp.next == tail) {
                                                tail = temp;
                                        }
                                        temp.next = temp.next.next;
                                        return true;
                                } else {
                                        return false;
                                }

                        }
                        temp = temp.next;
                        count++;
                }
                return false;
        }

        public ArrayList<Integer> getValues() {
                ArrayList<Integer> result = new ArrayList<>();
                Node temp = head;
                while (temp != null) {
                        result.add(temp.value);
                        temp = temp.next;
                }
                return result;
        }

        static class Node {
                int value;
                Node next;

                public Node(int value, Node next) {
                        this.value = value;
                        this.next = next;
                }
        }

        public static void main(String[] args) {
                SingleLinkedList singleLinkedList = new SingleLinkedList();
                singleLinkedList.insertHead(1);
                System.out.println(singleLinkedList.remove(2));
                System.out.println(singleLinkedList.remove(1));
        }
}
