public class RemoveDuplicatesLL {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    static ListNode removeDupFromLL(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        while (node != null) {
            if (node.next == null) break;
            else {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
        }

        return head;

    }
    public static void main(String[] args) {
        RemoveDuplicates r1 = new RemoveDuplicates();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);


        ListNode result = removeDupFromLL(l1);
        while (result != null) {
            System.out.println(result.val);
            result =result.next;
        }
    }
}
