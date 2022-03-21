package leetcode;

import historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * 17:14开始看题
 * 17:17 想到算法
 * 17:32 写完算法
 * 17:42 算法AC
 * CreateDate：2022/3/21 17:17 <br>
 */
public class ReverseList_206_standard {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }
        return prev;
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
        ReverseList_206_standard test = new ReverseList_206_standard();
        ListNode answer = test.reverseList(listNode1);
    }


}
