//public class LinkedList {
//
//    private class Node{
//        int data;
//        Node next;
//    }
//
//    private static Node mergeNodes(Node node1,Node node2){
//        if (node1==null&&node2==null){
//            return null;
//        }
//
//        if (node1==null){
//            return node2;
//        }
//
//        if (node2==null){
//            return node1;
//        }
//
//        Node node1dup = node1;
//        Node node2dup = node2;
//
//        while (node1dup.next!=null&&node2dup.next!=null){
//
//            int node1dupData = node1dup.data;
//            int node2dupData = node2dup.data;
//
//            if (node1Date<node2Date&&node1.next.data>node2Date){
//                Node temp = node1;
//                Node temp2 = node2.next;
//                node1.next=node2;
//                node2.next=node1.next;
//                node1=node2;
//
//                node2 = temp2;
//
//            }
//
//        }
//
//
//    }
//
//}
