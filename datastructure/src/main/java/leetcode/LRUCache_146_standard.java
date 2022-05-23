package leetcode;

import java.util.HashMap;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/5/23 15:59 <br>
 */
public class LRUCache_146_standard{

    private class Entry<K, V> {
        private K key;
        private V value;
        Entry<K, V> prev;
        Entry<K, V> next;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public Entry() {
        }
    }

    private int initialCapacity;
    private Entry<Integer, Integer> head;
    private Entry<Integer, Integer> tail;
    private HashMap<Integer, Entry<Integer, Integer>> hashMap = new HashMap<>();

    public LRUCache_146_standard(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        head = new Entry<>();
        tail = new Entry<>();
        head.next = tail;
        tail.prev = head;
    }

    Integer get(int key) {
        Entry<Integer, Integer> entry = hashMap.get(key);
        if (entry == null) {
            System.out.println(-1);
            return -1;
        }

        moveToTail(entry);
        return entry.value;
    }

    public void put(int key, int value) {
        Entry<Integer, Integer> entry = new Entry<>(key, value);
        Entry<Integer, Integer> oldEntry = hashMap.put(key, entry);
        if (oldEntry == null) {
            addToTail(entry);
            if (hashMap.size() > initialCapacity) {
                Integer oldKey = head.next.key;
                removeEntry(head.next);
                hashMap.remove(oldKey);
            }
        } else {
            removeEntry(oldEntry);
            addToTail(entry);
        }
    }

    void moveToTail(Entry<Integer, Integer> entry) {
        removeEntry(entry);
        addToTail(entry);
    }

    void removeEntry(Entry<Integer, Integer> entry) {
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;
    }

    void addToTail(Entry<Integer, Integer> entry) {
        tail.prev.next = entry;
        entry.next = tail;
        entry.prev = tail.prev;
        tail.prev = entry;
    }

    public static void main(String[] args) {
        LRUCache_146_standard lru = new LRUCache_146_standard(2);
        lru.get(2);
        lru.put(2, 1);
        lru.put(2, 2);
        lru.get(2);
        lru.put(1, 1);
        lru.put(4, 1);
        lru.get(2);
    }

}
