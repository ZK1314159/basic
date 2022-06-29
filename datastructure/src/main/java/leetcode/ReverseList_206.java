package leetcode;

import interview.historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/21 17:17 <br>
 */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = head;
            head = next;
            next = tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ReverseList_206 test = new ReverseList_206();
        ListNode answer = test.reverseList(listNode1);
    }


}
