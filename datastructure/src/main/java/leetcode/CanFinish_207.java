package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description：<br>
 * 9:34开始看题
 * 9:55 看完拓扑排序原理
 * 9:58 想到解法
 * CreateDate：2022/6/3 10:00 <br>
 */
public class CanFinish_207 {

    //1 <= numCourses <= 105
    //0 <= prerequisites.length <= 5000
    //prerequisites[i].length == 2
    //0 <= ai, bi < numCourses
    //prerequisites[i] 中的所有课程对互不相同
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>(numCourses);
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            inDegree[info[1]]++;
            List<Integer> tmp = list.get(info[0]);
            tmp.add(info[1]);
        }
        
        Deque<Integer> zeroDegree = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                zeroDegree.offer(i);
            }
        }
        if (zeroDegree.size() == 0) {
            return false;
        }

        int count = 0;
        while (! zeroDegree.isEmpty()) {
            Integer v = zeroDegree.poll();
            count++;
            List<Integer> adj = list.get(v);
            if (adj != null) {
                for (int j : adj) {
                    inDegree[j]--;
                    if (inDegree[j] == 0) {
                        zeroDegree.offer(j);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][] {{1, 0}};
        CanFinish_207 canFinish_207 = new CanFinish_207();
        boolean answer = canFinish_207.canFinish(numCourses, prerequisites);
    }

}
