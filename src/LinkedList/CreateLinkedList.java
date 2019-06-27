package LinkedList;

/**
 * @author Ge Yalu
 * created on 2019/6/27
 */
public class CreateLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class LinkedList {
        Node head;
        Node current;

        LinkedList() {
        }

        void add(int val) {
            if (head == null) {
                Node node = new Node(val);
                head = node;
                current = head;
            } else {
                Node node = new Node(val);
                current.next = node;
                current = current.next;
            }
        }

        void remove() {

        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 9; i++) {
            linkedList.add(i);
        }

        Node cur = linkedList.head;

        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}
