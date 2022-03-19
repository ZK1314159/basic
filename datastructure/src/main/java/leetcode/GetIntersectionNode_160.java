package leetcode;

import historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * 14:17开始看题
 * 14:36 看懂官方解答
 * 14:53 写完代码
 * 15:06 代码AC
 * CreateDate：2022/3/19 14:37 <br>
 */
public class GetIntersectionNode_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode Ahead = headA;
        ListNode Bhead = headB;
        while (true) {
            if (headA == null && headB == null) {
                return null;
            }
            if (headA == null ) {
                headA = Bhead;
            }
            if (headB == null) {
                headB = Ahead;
            }
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
    }

}
