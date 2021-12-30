package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Description：leetcode_218 天际线问题
 * <br>
 * CreateDate：2021/11/7 18:07 <br>
 */
public class GetSkyline {

    int[][] building;
    List<Integer> candidate;
    List<Integer> possible;
    List<List<Integer>> result;

    public List<List<Integer>> getSkyline(int[][] buildings) {
        building = buildings;
        candidate = new ArrayList<>();
        possible = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i < building.length; i++) {
            possible.add(i);
        }

        // 寻找第一个关键点
        findFirstKeyPoint();
        // 对结果做最后的处理
        handleResult();
        return result;
    }

    private void handleResult() {
        List<List<Integer>> removePoint = new ArrayList<>();
        for (int i = 1; i < result.size(); i++) {
            List<Integer> point = result.get(i);
            List<Integer> prePoint = result.get(i - 1);
            if (point.get(1).equals(prePoint.get(1))) {
                removePoint.add(point);
            }
        }
        if (! removePoint.isEmpty()) {
            result.removeAll(removePoint);
        }
    }

    private void findFirstKeyPoint() {
        // 将下一个相同起点的建筑加入到候选集中
        // 同时产生下一个关键点和考察点
        List<Integer> tmpCandidate = new ArrayList<>(1);
        if (possible.isEmpty()) {
            return;
        }
        int keyPoint = possible.get(0);
        tmpCandidate.add(keyPoint);
        for (int i = 1; i < possible.size(); i++) {
            if (building[possible.get(i)][0] > building[keyPoint][0]) {
                break;
            } else {
                tmpCandidate.add(possible.get(i));
                if (building[possible.get(i)][2] > building[keyPoint][2]) {
                    keyPoint = possible.get(i);
                }
            }
        }
        possible.removeAll(tmpCandidate);
        result.add(Arrays.asList(building[keyPoint][0], building[keyPoint][2]));
        // 从临时的候选者集合中剔除没有用的候选者
        Iterator<Integer> tmpCandidateIterator = tmpCandidate.iterator();
        while (tmpCandidateIterator.hasNext()) {
            Integer tmpCandidatePoint = tmpCandidateIterator.next();
            if (building[tmpCandidatePoint][1] <= building[keyPoint][1]) {
                if (! tmpCandidatePoint.equals(keyPoint)) {
                    tmpCandidateIterator.remove();
                }
            }
        }
        candidate.addAll(tmpCandidate);
        core(keyPoint);
    }
    
    private void core(int considerPoint) {
        if (possible.isEmpty() && candidate.isEmpty()) {
            result.add(Arrays.asList(building[considerPoint][1], building[considerPoint][2]));
            result.add(Arrays.asList(building[considerPoint][1], 0));
            return;
        }
        // 寻找下一个关键点
        // 是否找到横坐标小于考察点但纵坐标大于考察点的新建筑
        boolean find = false;
        Integer finalCandidate = 0;
        Iterator<Integer> possibleIterator = possible.iterator();
        while (possibleIterator.hasNext()) {
            Integer point = possibleIterator.next();
            if (building[point][0] > building[considerPoint][1]) {
                break;
            }
            // 找到新的关键点, 如果有多个，选横坐标最小的那个
            // 如果横坐标最小的有多个，选纵坐标最大的那个
            if (find) {
                if (building[point][0] > building[finalCandidate][0]) {
                    break;
                } else {
                    if (building[point][2] > building[finalCandidate][2]) {
                        finalCandidate = point;
                    }
                    candidate.add(point);
                    possibleIterator.remove();
                }
            } else {
                if (building[point][2] > building[considerPoint][2]){
                    candidate.add(point);
                    possibleIterator.remove();
                    finalCandidate = point;
                    find = true;
                } else {
                    if (building[point][1] > building[considerPoint][1]) {
                        candidate.add(point);
                    }
                    possibleIterator.remove();
                }
            }
        }
        // 找到了新建筑
        if (find) {
            List<Integer> newKeyPoint = Arrays.asList(building[finalCandidate][0], building[finalCandidate][2]);
            result.add(newKeyPoint);
            // 删除一些无用的候选者
            Iterator<Integer> candidateIterator = candidate.iterator();
            while (candidateIterator.hasNext()) {
                Integer nextCandidate = candidateIterator.next();
                if (building[nextCandidate][1] <= building[finalCandidate][1]) {
                    if (! nextCandidate.equals(finalCandidate)) {
                        candidateIterator.remove();
                    }
                }
            }
            core(finalCandidate);
        // 没有找到新建筑
        } else {
            // 考察点升级为关键点
            result.add(Arrays.asList(building[considerPoint][1], building[considerPoint][2]));
            // bug：没有及时删除无用的考察点，导致死循环
            candidate.remove((Integer) considerPoint);
            // 寻找新的考察点
            if (! candidate.isEmpty()) {
                int newNextPoint = candidate.get(0);
                for (int i = 1; i < candidate.size(); i++) {
                    Integer newPoint = candidate.get(i);
                    // bug: 最优的新考察点判断错误
                    if (building[newPoint][1] >= building[newNextPoint][1]
                            && building[newPoint][2] >= building[newNextPoint][2]
                        || building[newPoint][1] < building[newNextPoint][1]
                            && building[newPoint][2] > building[newNextPoint][2]) {
                        newNextPoint = newPoint;
                    }
                }
                // 删除一些无用的候选者
                Iterator<Integer> candidateIterator = candidate.iterator();
                while (candidateIterator.hasNext()) {
                    Integer nextCandidate = candidateIterator.next();
                    if (building[nextCandidate][1] <= building[newNextPoint][1]) {
                        if (! nextCandidate.equals(newNextPoint)) {
                            candidateIterator.remove();
                        }
                    }
                }
                result.add(Arrays.asList(building[considerPoint][1], building[newNextPoint][2]));
                core(newNextPoint);
            } else {
                // 将下一个相同起点的建筑加入到候选集中
                // 同时产生下一个关键点和考察点
                result.add(Arrays.asList(building[considerPoint][1], 0));
                findFirstKeyPoint();
            }
        }
    }

    public static void main(String[] args) {
        GetSkyline getSkyline = new GetSkyline();
//        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//        int[][] buildings = new int[][]{{1,20,1},{1,21,2},{1,22,3}};
//        int[][] buildings = new int[][]{{3,7,8},{3,8,7},{3,9,6},{3,10,5},{3,11,4},{3,12,3},{3,13,2},{3,14,1}};
//        int[][] buildings = new int[][]{{1,38,219},{2,19,228},{2,64,106},{3,80,65},{3,84,8},{4,12,8},{4,25,14},
//                {4,46,225},{4,67,187},{5,36,118},{5,48,211},{5,55,97},{6,42,92},{6,56,188},{7,37,42},{7,49,78},
//                {7,84,163},{8,44,212},{9,42,125},{9,85,200},{9,100,74},{10,13,58},{11,30,179},{12,32,215},{12,33,161},
//                {12,61,198},{13,38,48},{13,65,222},{14,22,1},{15,70,222},{16,19,196},{16,24,142},{16,25,176},
//                {16,57,114},{18,45,1},{19,79,149},{20,33,53},{21,29,41},{23,77,43},{24,41,75},{24,94,20},{27,63,2},
//                {31,69,58},{31,88,123},{31,88,146},{33,61,27},{35,62,190},{35,81,116},{37,97,81},{38,78,99},
//                {39,51,125},{39,98,144},{40,95,4},{45,89,229},{47,49,10},{47,99,152},{48,67,69},{48,72,1},
//                {49,73,204},{49,77,117},{50,61,174},{50,76,147},{52,64,4},{52,89,84},{54,70,201},{57,76,47},
//                {58,61,215},{58,98,57},{61,95,190},{66,71,34},{66,99,53},{67,74,9},{68,97,175},{70,88,131},
//                {74,77,155},{74,99,145},{76,88,26},{82,87,40},{83,84,132},{88,99,99}};
//        int[][] buildings = new int[][]{{2,4,70},{3,8,30},{6,100,41},{7,15,70},{10,30,102},{15,25,76},{60,80,91},
//                {70,90,72},{85,120,59}};// [[2,70],[4,30],[6,41],[7,70],[10,102],[30,41],[60,91],[80,72],[90,59]
//        // ,[120,0]]
        int[][] buildings = new int[][]{{4547,253463,513907},{16593,154606,197418},{20536,587972,480271},
                {25155,135407,277021},{45693,480063,10484},{57392,70775,887782},{69423,760082,373899},
                {93047,222798,416217},{105421,832604,877583},{113118,797930,760771},{128302,234173,548113},
                {137036,889837,902341},{151470,195177,920702},{153020,398494,465441},{153980,501882,565647},
                {159005,416356,28559},{218765,535515,140331},{303595,627878,399999},{333489,449295,827098},
                {359242,830671,455392},{390291,400129,693584},{429774,450923,637981},{493315,563384,655884},
                {500860,718561,769319},{507299,817616,228},{537517,989102,300696},{543853,843011,695472},
                {550404,559944,90888},{617555,907369,523648},{622624,989745,894596},{640808,867707,963706},
                {697210,716449,705689},{804555,914745,764029}};// [[4547,513907],[57392,887782],[70775,513907],
        // [105421,877583],[137036,902341],[151470,920702],[195177,902341],[640808,963706],[867707,902341],
        // [889837,894596],[989745,0]]
        List<List<Integer>> result = getSkyline.getSkyline(buildings);
        System.out.println(result);
    }
    
}
