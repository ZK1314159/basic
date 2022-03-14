package leetcode;

import historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * 21:40开始看题
 * 21:46 想到算法
 * 21:58 写完算法
 * 21:58 算法AC
 * CreateDate：2022/3/14 21:47 <br>
 */
public class MergeTwoLists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tail.next = list2;
                break;
            }
            if (list2 == null) {
                tail.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        return head.next;
    }

}
