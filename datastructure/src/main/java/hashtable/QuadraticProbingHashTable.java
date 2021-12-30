package main.java.hashtable;

class QuadraticProbingHashTable<T> {
    private static final int intCapacity = 10;
    private Entry<T>[] arr;

    class Entry<T> {
        T data;
        boolean isDeleted;

        public Entry(T t) {
            this(t, false);
        }

        private Entry(T t, boolean b) {
            data = t;
            isDeleted = b;
        }
    }

    //@SuppressWarnings("unchecked")
    private QuadraticProbingHashTable() {
        //@SuppressWarnings("unchecked")
        arr = new Entry[intCapacity];
    }

    private int hash(T t) {
        int i = (Integer) t;
        return i % 10;
    }

    private int find(T t) {
        int i = hash(t);
        int offset = 1;
        while (arr[i] != null) {
            if (arr[i].data.equals(t)) {
                return i;
            }
            i += offset;
            offset += 2;
            if (i > arr.length - 1) {
                i = i % arr.length;
            }
        }
        return i;
    }

    private boolean contains(T t) {
        int i = find(t);
        return isActive(arr[i]);
    }

    private boolean isActive(Entry<T> e) {
        return e != null && !e.isDeleted;
    }

    private boolean add(T t) {
        int i = find(t);
        if (arr[i] == null) {
            arr[i] = new Entry(t, false);
            return true;
        } else if (!arr[i].isDeleted) {
            return false;
        } else {
            arr[i].isDeleted = false;
            return false;
        }
    }

    private boolean remove(T t) {
        int i = find(t);
        if (arr[i] == null) {
            return false;
        } else if (arr[i].isDeleted) {
            return false;
        } else {
            arr[i].isDeleted = true;
            return true;
        }
    }

    public static void main(String[] args) {
        QuadraticProbingHashTable<Integer> s = new QuadraticProbingHashTable<>();
        s.add(4371);
        s.add(1323);
        s.add(6173);
        s.add(4199);
        s.add(4199);
        s.add(4344);
        s.add(9679);
        s.add(1989);
        //s.remove(4199);
        //s.remove(1989);
        //s.remove(1323);
        for (int i = 0; i < s.arr.length; i++) {
            if (s.arr[i] != null && !s.arr[i].isDeleted) {
                System.out.println(i + ":" + s.arr[i].data);
            } else {
                System.out.println(i + ":null");
            }
        }
    }
}
