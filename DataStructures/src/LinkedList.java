import java.util.HashSet;

public class LinkedList {
    Node head;
    static class Node {
        int data;
        Node next;
        Node (int d) {
            data = d;
            next = null;
        }
    }

    public  Node  createNode(int d) {
        Node newNode = new Node(d);
        return  newNode;
    }

    public void printList() {
        Node n = head;
        while (n!= null) {
            System.out.println(n.data + " ");
            n = n.next;

        }
    }

    public void insertFront() {
        Node newNode = createNode(4);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node prev_node){
        if (prev_node == null) {
            System.out.println("Cannot Insert");
        }

        Node newNode = createNode(5);
        newNode.next = prev_node.next;
        prev_node.next = newNode;
    }

    public void insertEnd() {
        Node newNode = createNode(6);
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        return;
    }

    public void deleteNode(int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
         while (temp.next != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
         }

         if (temp == null) return;

        prev.next = temp.next;
    }

    public void reverseList() {
        Node current = head;
        Node prev = null, next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public boolean detectLoop(Node node) {
        HashSet<Node> s = new HashSet<Node>();
        while (node != null) {
            if (s.contains(node)) return true;
            s.add(node);
            node = node.next;
        }
        return false;
    }

    public boolean isPalindrome (Node head) {
        Node slowPtr = head , fastPtr= head, secondHalf;
        Node prevSlowPtr = head;
        Node midNode = null;
        if (head != null && head.next !=null) {
            while (fastPtr != null && fastPtr.next != null) {
                fastPtr = fastPtr.next.next;
                prevSlowPtr = slowPtr;
                slowPtr = slowPtr.next;
            }

            if (fastPtr != null) {
                midNode = slowPtr;
                slowPtr = slowPtr.next;
            }

            secondHalf = slowPtr;
            prevSlowPtr.next = null;
//            reverseList();
        }
        return true;
    }

    public void reverseListRec(Node head) {
        if (head ==  null) return;

        reverseListRec(head.next);

        System.out.println(head.data + "  ");

    }

    public void removeDuplicate() {
        Node current = head;
        Node dup;
        if (head == null) return;
        while (current.next != null) {
            if (current.data == current.next.data) {
                dup = current.next.next;
                current.next = null;
                current.next = dup;
            } else {
                current = current.next;
            }
        }
    }

    public void removeDuplicateFromUnsorted() {
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            if(hs.contains(current.data)) {
                prev.next = current.next;
            }
            else {
                hs.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.head = new Node(1);
        Node second = new Node(4);
        llist.head.next = second;
        Node third = new Node(2);
        second.next = third;
        Node fourth = new Node(5);
        third.next = fourth;
        Node fifth = new Node(4);
        fourth.next = fifth;
        Node sixth = new Node(2);
        fifth.next = sixth;

//        boolean isPalindromeSet = llist.isPalindrome(llist.head);

        System.out.println("Initial Linked List");
        llist.printList();



//        llist.insertFront();
//        System.out.println("Inserting in the front Linked List");
//        llist.printList();
//
//        llist.insertAfter(second);
//        System.out.println("Inserting after a node in Linked List");
//        llist.printList();
//
//        llist.insertEnd();
//        System.out.println("AFter inserting at the end");
//        llist.printList();
//
//        llist.deleteNode(5);
//        System.out.println("AFter deleting node 5 ");
//        llist.printList();

//        llist.reverseList();
//        System.out.println("After reversing nodes ");
//        llist.printList();

//        llist.reverseListRec(llist.head);
////        third.next = llist.head;
//        boolean hasLoop = llist.detectLoop(llist.head);
//
//        if (hasLoop)   System.out.println(" Has loop");
//        else  System.out.println("No loop ");

//        llist.removeDuplicate();
//        System.out.println("AFter removing duplicates");
//        llist.printList();
        llist.removeDuplicateFromUnsorted();
        System.out.println("AFter removing dup");
        llist.printList();

    }
}

