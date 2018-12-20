package Medium;

public class SwapNodesinPairs {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; // D->1->2->3->4

        ListNode curr = head; // 1
        ListNode prev = dummy; // D
        while (curr != null && curr.next != null) {
            ListNode next = curr.next; // 2

            curr.next = next.next; // 1->3
            next.next = curr;// 2->1
            prev.next = next; // D->2

            prev = curr; // 1
            curr = curr.next; //3
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesinPairs p = new SwapNodesinPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = p.swapPairs(head);
        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
