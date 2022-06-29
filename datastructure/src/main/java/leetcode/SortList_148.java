package leetcode;

import interview.historry.exam2022.zijie.ListNode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/5/30 19:36 <br>
 */
public class SortList_148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        ListNode virtualHead = new ListNode(0, head);
        int step = 1;
        while (step < length) {
            int count = 0;
            ListNode last = virtualHead;
            while (last.next != null) {
                if (count + step * 2 <= length) {
                    last = sort(last, step, step);
                    count += step * 2;
                } else if (count + step < length){
                    sort(last, step, length - count - step);
                    break;
                } else {
                    break;
                }
            }
            step = step << 1;
        }
        return virtualHead.next;
    }

    ListNode sort(ListNode last, int leftLength, int rightLength) {
        ListNode second = last;
        for (int i = 0; i < leftLength; i++) {
            second = second.next;
        }
        ListNode firstEnd = second;
        second = second.next;
        int left = 0;
        int right = 0;
        ListNode first = last.next;
        while (left <= leftLength || right <= rightLength) {
            if (left < leftLength && right < rightLength) {
                if (first.val <= second.val) {
                    last.next = first;
                    first = first.next;
                    left++;
                } else {
                    last.next = second;
                    second = second.next;
                    right++;
                }
                last = last.next;
            } else if (left == leftLength) {
                last.next = second;
                while (right < rightLength - 1) {
                    second = second.next;
                    right++;
                }
                return second;
            } else {
                last.next = first;
                firstEnd.next = second;
                return firstEnd;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] array = new int[] {-1,5,3,4,0};
        int[] array = new int[] {4,3,2,1};
        ListNode listNode = ListNodeUtil.getListNode(array);
        SortList_148 sortList_148 = new SortList_148();
        ListNode result = sortList_148.sortList(listNode);
    }

}
