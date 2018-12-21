package Medium;

public class PartitionList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode less = new ListNode(0), more = new ListNode(0), left = less, right = more;
        while (head != null) {
            if (head.val < x) {
                less.next = new ListNode(head.val);
                less =  less.next;
            } else {
                more.next = new ListNode(head.val);
                more = more.next;
            }

            head = head.next;
        }

        less.next = right.next;
        return left.next;
    }
    public static void main(String[] args) {
        PartitionList l = new PartitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result = l.partition(head, 3);
        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
