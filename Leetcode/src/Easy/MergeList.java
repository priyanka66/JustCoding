package Easy;

public class MergeList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                result.next = new ListNode(l2.val);;
                l2 = l2.next;
            }
//            System.out.println(result.val);
            result = result.next;
            if (l1 == null) {
                while (l2 != null) {
                    result.next = new ListNode(l2.val);
                    l2 = l2.next;
                    result = result.next;
                }
            }

            if (l2 == null) {
                while (l1 != null) {
                    result.next = new ListNode(l1.val);;
                    l1 = l1.next;
                    result = result.next;
                }
            }
        }

        return node.next;
    }
    public static void main(String[] args) {
        MergeList m1 = new MergeList();
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
//        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
//        l2.next.next = new ListNode(4);

        ListNode l3 = mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 =l3.next;
        }

    }
}
