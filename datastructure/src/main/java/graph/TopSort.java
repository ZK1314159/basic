package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/1 20:24 <br>
 */
public class TopSort {
    public static class TopNode {
        int inDegree;
        int id;
        int topNumber;
        List<TopNode> adj = new ArrayList<>();
        TopNode(int id) {
            this.id = id;
        }
    }

    public void sort(TopNode[] topNodes) {
        Deque<TopNode> deque = new LinkedList<>();
        for (TopNode node : topNodes) {
            if (node.inDegree == 0) {
                deque.offer(node);
            }
        }
        if (deque.isEmpty()) {
            throw new RuntimeException("拓扑图有圈！");
        }
        int topNumber = 0;
        while (! deque.isEmpty()) {
            TopNode topNode = deque.poll();
            topNode.topNumber = topNumber;
            topNumber++;
            for (TopNode node : topNode.adj) {
                node.inDegree--;
                if (node.inDegree == 0) {
                    deque.offer(node);
                }
            }
        }
        if (topNumber != topNodes.length) {
            throw new RuntimeException("拓扑图有圈！");
        }
    }

    public void buildMap(TopNode[] topNodes) {
        for (int i = 0; i < topNodes.length; i++) {
            topNodes[i] = new TopNode(i);
        }
        topNodes[0].adj.add(topNodes[1]);
        topNodes[0].adj.add(topNodes[2]);
        topNodes[0].adj.add(topNodes[3]);
        topNodes[1].adj.add(topNodes[3]);
        topNodes[1].adj.add(topNodes[4]);
        topNodes[2].adj.add(topNodes[5]);
        topNodes[3].adj.add(topNodes[2]);
        topNodes[3].adj.add(topNodes[5]);
        topNodes[3].adj.add(topNodes[6]);
        topNodes[4].adj.add(topNodes[3]);
        topNodes[4].adj.add(topNodes[6]);
        topNodes[6].adj.add(topNodes[5]);
        for (TopNode topNode : topNodes) {
            for (TopNode node : topNode.adj) {
                node.inDegree++;
            }
        }
    }

    void print(TopNode[] topNodes) {
        List<TopNode> list = Arrays.asList(topNodes);
        list = new ArrayList<>(list);
        list = list.stream().sorted(Comparator.comparingInt(v -> v.topNumber))
                .collect(Collectors.toList());
        for (TopNode topNode : list) {
            System.out.print((topNode.id + 1) + " ");
        }
    }


    public static void main(String[] args) {
        TopNode[] topNodes = new TopNode[7];
        TopSort topSort = new TopSort();
        topSort.buildMap(topNodes);
        topSort.sort(topNodes);
        topSort.print(topNodes);
    }

}
