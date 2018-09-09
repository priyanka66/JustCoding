public class MergeList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = new ListNode(0);
        ListNode node  = res;
        while (l1!=null && l2 !=null) {
            if (l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            res = res.next;

            if (l1 == null) {
                while (l2 != null) {
                    res.next = new ListNode(l2.val);
                    res = res.next;
                    l2 = l2.next;
                }
            }

            if (l2 == null) {
                while (l1 != null) {
                    res.next = new ListNode(l1.val);
                    res = res.next;
                    l1 = l1.next;
                }
            }
        }

        return node.next;

    }
    public static void main(String[] args) {
        MergeList m = new MergeList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res  = m.mergeTwoLists(l1, l2);

        while (res!=null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
