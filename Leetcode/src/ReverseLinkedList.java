
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

    public static void main (String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        LinkedListCycle.ListNode head = new LinkedListCycle.ListNode(1);
        head.next = new LinkedListCycle.ListNode(2);
        head.next.next = new LinkedListCycle.ListNode(3);
        head.next.next.next = new LinkedListCycle.ListNode(4);
        head.next.next.next.next = new LinkedListCycle.ListNode(5);

        LinkedListCycle.ListNode node = head;

        while (node != null) {
            System.out.print(" " +node.val);
            node = node.next;

        }
        System.out.println();
        LinkedListCycle.ListNode reverse = r.reverseList(head);

        while (reverse != null) {
            System.out.print(" " +reverse.val);
            reverse = reverse.next;

        }
    }
}
