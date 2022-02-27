package historry.exam2022.zijie;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/24 18:03 <br>
 */
public class NewMergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.offer(listNode);
            }
        }

        ListNode tail = new ListNode();
        ListNode head = tail;
        while (! priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
        }

        return head.next;
    }

     public void init(ListNode[] listNodes) {
         listNodes[0] = new ListNode(0);
         listNodes[1] = null;
         listNodes[2] = new ListNode(2);
     }

     public static void main(String[] args) {
         NewMergeKList mergeKList = new NewMergeKList();
         ListNode[] listNodes = new ListNode[3];
         mergeKList.init(listNodes);
         ListNode listNode = mergeKList.mergeKLists(listNodes);
     }

}


