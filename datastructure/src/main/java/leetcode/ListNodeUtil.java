package leetcode;

import interview.historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/5/30 23:15 <br>
 */
public class ListNodeUtil {

    public static ListNode getListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        if (array.length == 1) {
            return new ListNode(array[0]);
        }
        ListNode head = new ListNode(array[0]);
        ListNode tail = head;
        for (int i = 1; i < array.length; i++) {
            tail.next = new ListNode(array[i]);
            tail = tail.next;
        }
        return head;
    }

}
