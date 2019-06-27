package LinkedList;

/**
 * @author Ge Yalu
 * created on 2019/6/27
 */
public class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}