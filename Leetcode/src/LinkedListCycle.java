import java.util.LinkedList;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }


    private boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head, p2=head;
        while (p1!=null && p2!=null) {
            if (p2.next == null) {
                p2 = null;
            } else {
                if (p1.next == p2.next.next) return true;
                p2 = p2.next.next;
            }
            p1 = p1.next;
        }

        return false;
    }


    private ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode p1=head, p2=head;
        while (p1 != null && p2 != null) {
            if (p2.next != null) p2 = p2.next.next;
            else p2=null;
            p1 = p1.next;
            if (p1 == p2) {
                p1 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }

                return p1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        LinkedListCycle l = new LinkedListCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head.next.next.next.next.next = head.next;

        ListNode node = head;

        System.out.println(l.hasCycle(node));
        System.out.println(l.detectCycle(node).val);
    }
}
