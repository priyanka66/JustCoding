package Easy;

public class ReverseLinkedList {

    private LinkedListCycle.ListNode reverseList(LinkedListCycle.ListNode head) {
        LinkedListCycle.ListNode cur = head, next, prev = null;

        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head = prev;
        return head;
    }

    LinkedListCycle.ListNode reverseListV1(LinkedListCycle.ListNode head) {
        if (head == null) return null;
        return reverseListV1(head, null);
    }

    LinkedListCycle.ListNode reverseListV1(LinkedListCycle.ListNode head, LinkedListCycle.ListNode newHead) {
        if (head == null) return newHead;
        LinkedListCycle.ListNode next = head.next;
        head.next = newHead;

        return reverseListV1(next, head);
    }
    public static void main (String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        LinkedListCycle.ListNode head = new LinkedListCycle.ListNode(1);
        head.next = new LinkedListCycle.ListNode(2);
        head.next.next = new LinkedListCycle.ListNode(3);
        head.next.next.next = new LinkedListCycle.ListNode(4);
        head.next.next.next.next = new LinkedListCycle.ListNode(5);

        LinkedListCycle.ListNode node = head;
        LinkedListCycle.ListNode head2 = head;

        while (node != null) {
            System.out.print(" " +node.val);
            node = node.next;

        }
//        System.out.println();
//        LinkedListCycle.ListNode reverse = r.reverseList(head);
//
//        while (reverse != null) {
//            System.out.print(" " +reverse.val);
//            reverse = reverse.next;
//
//        }

        LinkedListCycle.ListNode reverse = r.reverseListV1(head2);
        System.out.println();
        while (reverse != null) {
            System.out.print(" " +reverse.val);
            reverse = reverse.next;

        }
    }


}
