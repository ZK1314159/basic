package leetcode;

import historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * 17:04 开始读题
 * 17:20 看完官方算法
 * 17:44 写完官方算法
 * 18:03 官方算法AC
 * CreateDate：2022/3/22 17:21 <br>
 */
public class IsPalindrome_234 {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;
        while (true) {
            if (fast.next == null) {
                ListNode tmp = slow.next;
                slow.next = prev;
                return compare(slow, tmp);
            }
            if (fast.next.next == null) {
                ListNode tmp = slow.next;
                slow.next = prev;
                return compare(slow, tmp.next);
            }

            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
            fast = fast.next.next;
        }
    }

    boolean compare(ListNode left, ListNode right) {
        while (true) {
            if (left == null && right == null) {
                return true;
            }
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
            } else {
                return false;
            }
            left = left.next;
            right = right.next;
        }
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node0.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        IsPalindrome_234 test = new IsPalindrome_234();
        boolean answer = test.isPalindrome(node0);
    }

}
