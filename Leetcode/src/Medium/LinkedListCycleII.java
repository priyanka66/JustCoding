package Medium;

public class LinkedListCycleII {
    public static class ListNode {
        int  val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1=head, p2=head;
        while (p1 != null  && p2 != null) {
            if (p2.next != null) {
                p2 = p2.next.next;
            } else {
                p2 = null;
            }
            p1 = p1.next;
            if  (p1 == p2) {
                p1 = head;
                while (p1 != p2) {
                    p1 =  p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        LinkedListCycleII c = new LinkedListCycleII();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next =  new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(c.detectCycle(head).val);
    }
}
