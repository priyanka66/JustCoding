package Medium;

public class SortList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, prev=null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(slow);

        return merge(first, second);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode node = new ListNode(0), res = node;
        while (head1 != null && head2 !=null) {
            if (head1.val <= head2.val) {
                res.next = head1;
                head1 = head1.next;
            } else {
                res.next = head2;
                head2 = head2.next;
            }
            res = res.next;
        }

        if (head1 == null) {
            res.next = head2;
        } else {
            res.next = head1;
        }

        return node.next;
    }


    public static void main(String[] args) {
        SortList s = new SortList();
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);

        ListNode result = s.sortList(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
