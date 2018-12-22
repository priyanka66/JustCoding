package Medium;

public class ReverseLinkedListII {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode head2 = new ListNode(-1);
        head2.next = head;
        ListNode prev = head2,next = head.next;
        while (m > 1) {
            prev = prev.next;
            m--;
        }
        while (n > 1) {
            next = next.next;
            n--;
        }
        ListNode last = prev.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = last.next;
        }

        return head2.next;
    }
    public static void main(String[] args) {

        ReverseLinkedListII r = new ReverseLinkedListII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next =  new ListNode(5);
        ListNode result = r.reverseBetween(head, 2,4);
        while (result!=null) {
            System.out.println(result.val);
            result =  result.next;
        }
    }
}
