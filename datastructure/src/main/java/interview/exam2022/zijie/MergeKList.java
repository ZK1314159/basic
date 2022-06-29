package interview.historry.exam2022.zijie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/24 18:03 <br>
 */
public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        List<ListNode> listNodes = Arrays.asList(lists);
        listNodes = new ArrayList<>(listNodes);
        listNodes = listNodes.stream().filter(Objects::nonNull).collect(Collectors.toList());

        ListNode end = new ListNode();
        ListNode start = end;
        while (listNodes.size() > 0) {
            ListNode min = listNodes.get(0);
            int position = 0;
            for (int i = 1; i < listNodes.size(); i++) {
                if (listNodes.get(i).val < min.val) {
                    min = listNodes.get(i);
                    position = i;
                }
            }
            end.next = min;
            if (min.next != null) {
                listNodes.set(position, min.next);
            } else {
                listNodes.remove(min);
            }
            end = end.next;
        }
        end.next = null;

        return start.next;
    }

     public void init(ListNode[] listNodes) {
         listNodes[0] = new ListNode(0);
         listNodes[1] = new ListNode(1);
         listNodes[2] = new ListNode(2);
     }

     public static void main(String[] args) {
         MergeKList mergeKList = new MergeKList();
         ListNode[] listNodes = new ListNode[3];
         mergeKList.init(listNodes);
         ListNode listNode = mergeKList.mergeKLists(listNodes);
     }

}


