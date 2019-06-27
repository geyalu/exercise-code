package LinkedList;

/**
 * @author Ge Yalu
 * created on 2019/6/27
 */
public class LinkedListExercise {
    /**
     * 查找单链表中的倒数第k个结点：双指针
     */
    public Node findLastNode(Node head, int k) {
        if (k == 0 || head == null) {
            return null;
        }

        Node first = head;
        Node second = head;

        //让second结点往后挪k-1个位置
        for (int i = 0; i < k - 1; i++) {
            System.out.println("i的值是" + i);
            second = second.next;
            if (second == null) { //说明k的值已经大于链表的长度了
                //throw new NullPointerException("链表的长度小于" + k); //我们自己抛出异常，给用户以提示
                return null;
            }
        }

        //让first和second结点整体向后移动，直到second走到最后一个结点
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        //当second结点走到最后一个节点的时候，此时first指向的结点就是我们要找的结点
        return first;
    }

    /**
     * 查找链表的中间结点：快慢指针
     */
    public Node findMidNode(Node head) {

        if (head == null) {
            return null;
        }

        Node first = head;
        Node second = head;
        //每次移动时，让second结点移动两位，first结点移动一位
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        //直到second结点移动到null时，此时first指针指向的位置就是中间结点的位置
        return first;
    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     */
    public Node mergeTwoLists(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }

        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        Node head = new Node(0);
        Node current = head;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                current.next = node1;
                current = current.next;
                node1 = node1.next;
            } else {
                current.next = node2;
                current = current.next;
                node2 = node2.next;
            }
        }

        if (node1 == null) {
            current.next = node2;
        }

        if (node2 == null) {
            current.next = node1;
        }

        return head.next;
    }

    /**
     * 反转单向链表
     */
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node next = null;
        Node pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 从尾到头打印单链表：要么自己使用栈，要么让系统使用栈，也就是递归。
     */
    public void reversePrint(Node head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.println(head.data);
    }

    /**
     * 链表是否有环
     * 定义两个指针，同时从链表的头节点出发，一个指针一次走一步，另一个指针一次走两步。如果走得快的指针追上了走得慢的指针，
     * 那么链表就是环形链表；如果走得快的指针走到了链表的末尾（next指向 NULL）都没有追上第一个指针，那么链表就不是环形链表
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

    /**
     * O(1)时间删除链表节点，从无头单链表中删除节点
     * 用下一个节点数据覆盖要删除的节点，然后删除下一个节点。但是如果节点是尾节点时，该方法就行不通了。
     */
    public static void deleteRandomNode(Node node) {
        Node tmp = node.next;
        node.next = tmp.next;
        node.data = tmp.data;
    }
}
