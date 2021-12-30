package hashtable;

class DoubleHashTable<T> {
    static final int intCapacity = 10;
    Entry<T>[] arr;

    class Entry<T> {
        T data;
        boolean isDeleted;

        public Entry(T t) {
            this(t, false);
        }

        public Entry(T t, boolean b) {
            data = t;
            isDeleted = b;
        }
    }

    //@SuppressWarnings("unchecked")
    public DoubleHashTable() {
        //@SuppressWarnings("unchecked")
        arr = new Entry[intCapacity];
    }

    int hash(T t) {
        int i = (Integer) t;
        return i % 10;
    }

    int hash2(T t) {
        int i = (Integer) t;
        return 7 - i % 7;
    }

    int find(T t) {
        int i = hash(t);
        int j = 1;
        while (arr[i] != null) {
            if (arr[i].data.equals(t)) {
                return i;
            }
            i += j * hash2(t);
            j++;
            if (i > arr.length - 1) {
                i = i % arr.length;
            }
        }
        return i;
    }

    boolean contains(T t) {
        int i = find(t);
        return isActive(arr[i]);
    }

    boolean isActive(Entry<T> e) {
        return e != null && e.isDeleted == false;
    }

    boolean add(T t) {
        int i = find(t);
        if (arr[i] == null) {
            arr[i] = new Entry<T>(t, false);
            return true;
        } else if (arr[i].isDeleted == false) {
            return false;
        } else {
            arr[i].isDeleted = false;
            return false;
        }
    }

    boolean remove(T t) {
        int i = find(t);
        if (arr[i] == null) {
            return false;
        } else if (arr[i].isDeleted == true) {
            return false;
        } else {
            arr[i].isDeleted = true;
            return true;
        }
    }

    public static void main(String[] args) {
        DoubleHashTable<Integer> s = new DoubleHashTable<>();
        s.add(4371);
        s.add(1323);
        s.add(6173);
        s.add(4199);
        s.add(4199);
        s.add(4344);
        s.add(9679);
        //s.add(1989);
        //s.remove(4199);
        //s.remove(1989);
        //s.remove(1323);
        for (int i = 0; i < s.arr.length; i++) {
            if (s.arr[i] != null && s.arr[i].isDeleted == false) {
                System.out.println(i + ": " + s.arr[i].data);
            } else {
                System.out.println(i + ": null");
            }
        }
    }
}
