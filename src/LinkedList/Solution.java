package LinkedList;

public class Solution {

    class Node {
        int val;
        Node next;
    }

    /*
    定义两个指针，同时从链表的头节点出发，一个指针一次走一步，另一个指针一次走两步。如果走得快的指针追上了走得慢的指针，
    那么链表就是环形链表；如果走得快的指针走到了链表的末尾（next指向 NULL）都没有追上第一个指针，那么链表就不是环形链表
     */
    public static boolean detectCycle(Node head) {
        Node fast = head.next.next;
        Node slow = head;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
