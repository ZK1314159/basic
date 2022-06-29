package leetcode;

import interview.historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * 16:57 想到o(N)空间占用的算法
 * 17:09 了解了官方的算法
 * 17:24 官方的算法AC
 * CreateDate：2022/3/18 16:23 <br>
 */
public class HasCycle_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
