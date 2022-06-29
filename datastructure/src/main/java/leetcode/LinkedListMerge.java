package leetcode;

import interview.historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/1 15:48 <br>
 */
public class LinkedListMerge {

    public ListNode merge(ListNode left, ListNode right) {
        ListNode virtual = new ListNode();
        ListNode head = virtual;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null) {
            head.next = left;
        } else if (right != null){
            head.next = right;
        }
        return virtual.next;
    }

}
