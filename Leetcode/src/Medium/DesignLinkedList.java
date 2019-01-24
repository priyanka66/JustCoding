package Medium;

public class DesignLinkedList {

    public class LinkedList {
        int val;
        LinkedList next;
        public LinkedList(int x)  {
            val=x;
            next = null;
        }
    }

    LinkedList head, tail;
    int size;

    public DesignLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index >= size) return -1;
        LinkedList node = head;
        for(int i=0;i<index;i++) node = node.next;

        return node.val;
    }

    public void addAtHead(int val) {
        LinkedList node = new LinkedList(val);
        node.next = head;
        head = node;
        if (tail == null) tail = node;
        size++;
    }

    public void addAtTail(int val) {
        LinkedList node = new LinkedList(val);
        if (tail != null) tail.next = node;
        else head = node;
        tail = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        LinkedList node = new LinkedList(val), temp=head;
        for (int i=0;i<index-1;i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index > size) return;
        if (size == 0) return;
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        } else {
            LinkedList node = head;
            for (int i=0;i<index-1;i++) {
                node = node.next;
            }
            if (index == size-1) {
                node.next = null;
                tail = node;
                size--;
            } else {
                node.next = node.next.next;
                size--;
            }
        }
    }


    public static void main(String[] args) {
        DesignLinkedList linkedList = new DesignLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList.get(1)); //returns 3
    }
}
