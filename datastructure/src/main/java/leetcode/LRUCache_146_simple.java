package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/5/23 15:59 <br>
 */
public class LRUCache_146_simple extends LinkedHashMap<Integer, Integer> {

    private int initialCapacity;

    public LRUCache_146_simple(int initialCapacity) {
        // 参数true代表每次查询后将查询的key放到LinkedHashMap维护的链表的最后，代表最近被操作过
        super(initialCapacity, 0.75F, true);
        this.initialCapacity = initialCapacity;
    }

    Integer get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        // LinkedHashMap中put的元素都会被放入到链表的最后，这个逻辑在newNode()中
        // 插入完成后会调用afterNodeInsertion(), 这个方法中会调用removeEldestEntry()
        super.put(key, value);
    }

    // 重新写该方法代表每次插入元素后将LinkedHashMap维护的链表第一个元素删除的触发条件
    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > initialCapacity;
    }

    public static void main(String[] args) {
        LRUCache_146_simple lru = new LRUCache_146_simple(3);
        lru.put(1, 1);
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(3, 0.75F, true);
        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 1);
        linkedHashMap.put(3, 1);
        linkedHashMap.put(4, 1);

    }

}
