package cache;

public class LRU {
    int size = 10;
    int length = 0;

    NodePair current = null;
    NodePair head = null;


    /**
     * 双向链表数据结构
     */
    private class NodePair {
        NodePair frontNode;
        NodePair postNode;
        int data;
    }

    private static NodePair searchNode(int data, NodePair head) {
        if (head.data == data) {
            return head;
        }

        NodePair tempNode = head.postNode;

        while (tempNode.postNode != null && tempNode.postNode.data != data) {
            tempNode = tempNode.postNode;
        }

        if (tempNode.postNode == null) {
            return null;
        }

        NodePair tempNodeFront = tempNode.frontNode;
        NodePair tempNodePost = tempNode.postNode;

        tempNodeFront.postNode = tempNodePost;
        tempNodePost.frontNode = tempNodeFront;

        tempNode.postNode = head;
        head.frontNode = tempNode;
        tempNode.frontNode = null;

        return tempNode;

    }

    /**
     * 根据数据逆序查找链表中是否有此节点，有，则把该点提出来，放到current的位置
     * 当匹配到的时候，返回true
     *
     * @param data
     */
    public boolean searchNode(int data) {
        boolean flag = false;
        NodePair tempNode = current;
        //不匹配，即没找到，则继续查找
        while (tempNode.frontNode != null || tempNode.data != data) {
            tempNode = tempNode.frontNode;
        }
        //这个判读表示匹配到了
        if (tempNode.data == data) {
            tempNode.frontNode.postNode = tempNode.postNode;
            tempNode.postNode.frontNode = tempNode.frontNode;
            current = tempNode;
            flag = true;
        }

        return flag;
    }

    /**
     * 往LRU缓存中插入数据
     *
     * @param data
     */
    public void addNode(int data) {
        //缓存未满，不需要删除，直接插入
        if (length <= size) {
            NodePair tempNode = new NodePair();
            tempNode.frontNode = current;
            tempNode.postNode = null;
            tempNode.data = data;
            current = tempNode;
            length++;
        }
        //缓存满了，查找缓存中有没有数据
        else {
            if (!searchNode(data)) {
                //缓存中没有，需要给head节点重新赋值
                resetHeadNode(data);
            }
        }
    }

    /**
     * 给head节点重新赋值操作
     * 实现细节是：
     * 0.倒数第二个点（head的下一个点）的frontNode引用指向null
     * 1.给head所指节点重新赋值
     * 2.current节点的frontNode引用指向head
     * 3.把current节点指向head
     * 4.把head指向head的下一个节点（即，倒数第二个点）
     */
    public void resetHeadNode(int data) {
        NodePair secondNode = head.postNode;

        head.postNode.frontNode = null;

        head.data = data;
        head.frontNode = current;
        head.postNode = null;

        current.postNode = head;

        current = head;

        head = secondNode;
    }


}
