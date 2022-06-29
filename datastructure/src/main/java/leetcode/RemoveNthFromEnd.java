package leetcode;

import interview.historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/4 15:59 <br>
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        int count = 1;
        ListNode pre = head;
        while (head.next != null) {
            count++;
            if (count >= n + 2) {
                pre = pre.next;
            }
            head = head.next;
        }

        if (count == n) {
            if (count == 1) {
                return null;
            }
            return start.next;
        }
        pre.next = pre.next.next;

        return start;
    }

}
