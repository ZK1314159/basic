package leetcode;

import historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/27 11:39 <br>
 */
public class AddTwoNumber_1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int before = 0;
        ListNode tail = l1;
        ListNode head = tail;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + before;
            if (sum >= 10) {
                sum -= 10;
                before = 1;
            } else {
                before = 0;
            }
            tail.val = sum;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (l1 == null && l2 == null) {
                if (before == 1) {
                    tail.next = new ListNode(1);
                    break;
                }
            }

            if (l1 == null) {
                tail.next = l2;
            } else {
                tail.next = l1;
            }
            tail = tail.next;
        }

        return head;
    }

    void build(ListNode node1, ListNode node2) {
        node1.next = new ListNode(4);
        node1 = node1.next;
        node1.next = new ListNode(9);

        node2.next = new ListNode(6);
        node2 = node2.next;
        node2.next = new ListNode(4);
        node2 = node2.next;
        node2.next = new ListNode(9);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(5);
        AddTwoNumber_1 addTwoNumber = new AddTwoNumber_1();
        addTwoNumber.build(node1, node2);
        ListNode result = addTwoNumber.addTwoNumbers(node1, node2);
    }

}
