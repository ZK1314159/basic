package leetcode;

import historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/27 11:39 <br>
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int before = 0;
        ListNode tail = l1;
        ListNode head = tail;

        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            int sum = a + b + before;
            if (sum >= 10) {
                sum -= 10;
                before = 1;
            } else {
                before = 0;
            }
            tail.val = sum;

            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 == null) {
                if (before == 1) {
                    tail.next = new ListNode(1);
                    tail = tail.next;
                    before = 0;
                }
                break;
            }

            if (l1 == null) {
                tail.next = l2;
                tail = tail.next;
                break;
            }
            if (l2 == null) {
                tail.next = l1;
                tail = tail.next;
                break;
            }

            tail = tail.next;
        }

        while (tail != null) {
            int a = tail.val;
            int sum = a + before;
            if (sum >= 10) {
                before = 1;
                sum -= 10;
            } else {
                before = 0;
            }
            tail.val = sum;
            if (tail.next == null) {
                if (before == 1) {
                    tail.next = new ListNode(1);
                }
                break;
            } else {
                tail = tail.next;
            }
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
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        addTwoNumber.build(node1, node2);
        ListNode result = addTwoNumber.addTwoNumbers(node1, node2);
    }

}
