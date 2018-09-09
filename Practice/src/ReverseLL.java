public class ReverseLL {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head ;
        ListNode prev = null, cur=head, next=null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }

    public ListNode reverseListRec (ListNode head) {
        if (head == null) return head;
        return revLL(head, null);
    }

    public ListNode revLL(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return revLL(next, head);
    }
    public static void main(String[] args) {
        ReverseLL r = new ReverseLL();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

//        ListNode l2 = r.reverseList(l1);
       ListNode l2 = r.reverseListRec(l1);
        while (l2!=null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }
}
