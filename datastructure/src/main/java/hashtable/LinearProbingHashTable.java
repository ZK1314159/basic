package main.java.hashtable;

class LinearProbingHashTable<T> {
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
    public LinearProbingHashTable() {
        //@SuppressWarnings("unchecked")
        arr = new Entry[intCapacity];
    }

    int hash(T t) {
        int i = (Integer) t;
        return i % 10;
    }

    boolean contains(T t) {
        int i = hash(t);
        while (arr[i] != null) {
            if (arr[i].data.equals(t)) {
                if (arr[i].isDeleted == true) {
                    return false;
                }
                return true;
            }
            i++;
        }
        return false;
    }

    boolean add(T t) {
        int i = hash(t);
        while (arr[i] != null) {
            if (arr[i].data.equals(t)) {
                if (arr[i].isDeleted == true) {
                    arr[i].isDeleted = false;
                    return true;
                }
                return false;
            } else {
                i++;
                if (i > arr.length - 1) {
                    i = i % arr.length;
                }
            }
        }
        arr[i] = new Entry<T>(t, false);
        return true;
    }

    boolean remove(T t) {
        int i = hash(t);
        while (arr[i] != null) {
            if (arr[i].data.equals(t)) {
                if (arr[i].isDeleted == true) {
                    return false;
                }
                arr[i].isDeleted = true;
                return true;
            } else {
                i++;
                if (i > arr.length - 1) {
                    i = i % arr.length;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinearProbingHashTable<Integer> s = new LinearProbingHashTable<>();
        s.add(4371);
        s.add(1323);
        s.add(6173);
        s.add(4199);
        s.add(4199);
        s.add(4344);
        s.add(9679);
        s.add(1989);
        //s.remove(4199);
        //s.remove(6173);
        //s.remove(1323);
        for (int i = 0; i < s.arr.length; i++) {
            if (s.arr[i] != null && s.arr[i].isDeleted == false) {
                System.out.println(i + ":" + s.arr[i].data);
            } else {
                System.out.println(i + ":null");
            }
        }
    }
}
