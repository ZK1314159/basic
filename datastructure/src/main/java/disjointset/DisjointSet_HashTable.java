package main.java.disjointset;

//自己构造了哈希表的变种处理字符串的不相交集问题，过于复杂
public class DisjointSet_HashTable {
    private Node[] arr;

    private class Node {
        String key;
        String father;
        int height;

        Node(String key, String father, int height) {
            this.key = key;
            this.father = father;
            this.height = height;
        }

        public String toString() {
            return "key[" + key + "]" + " " + "father[" + father + "]" + " " + "height[" + height + "]";
        }
    }

    private DisjointSet_HashTable(int in) {
        arr = new Node[toPrime(in * 2)];
    }

    private void build(String[] st) {
        for (String s : st) {
            add(s);
        }
    }

    private int hash(String st) {
        int i = st.hashCode() % arr.length;
        if (i < 0) {
            i += arr.length;
        }
        return i;
    }

    private int pos(String st) {
        int i = hash(st);
        while (!arr[i].key.equals(st)) {
            i++;
        }
        return i;
    }

    private void add(String st) {
        int i = hash(st);
        while (arr[i] != null) {
            if (arr[i].key.equals(st)) {
                return;
            } else {
                i++;
                if (i > arr.length - 1) {
                    i = i % arr.length;
                }
            }
        }
        arr[i] = new Node(st, null, 1);
    }

    private int toPrime(int size) {
        if (size % 2 == 0) {
            size++;
        }
        for (; !isPrime(size); size += 2) ;
        return size;
    }

    private boolean isPrime(int n) {
        if (n == 1 || n == 3) {
            return true;
        } else {
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private void union(String st1, String st2) {
        String root1 = find(st1);
        String root2 = find(st2);
        int pos1 = pos(root1);
        int pos2 = pos(root2);
        if (arr[pos1].height > arr[pos2].height) {
            arr[pos2].father = root1;
        } else {
            if (arr[pos1].height == arr[pos2].height) {
                arr[pos2].height++;
            }
            arr[pos1].father = root2;
        }
    }

    private String find(String st) {
        int pos = pos(st);
        if (arr[pos].father == null) {
            return st;
        }
        return arr[pos].father = find(arr[pos].father);
    }

    public static void main(String[] args) {
        String[] st = {"c", "java", "cpp", "python", "php", "spring", "mysql", "oracle", "love", "hate"};
        DisjointSet_HashTable dsh = new DisjointSet_HashTable(st.length);
        dsh.build(st);
        dsh.union("java", "python");
        dsh.union("c", "cpp");
        dsh.union("java", "c");
        System.out.println(dsh.find("java"));
        System.out.println(dsh.find("cpp"));
        System.out.println(dsh.find("python"));
        System.out.println(dsh.find("c"));
        for (int i = 0; i < dsh.arr.length; i++) {
            if (dsh.arr[i] == null) {
                //System.out.println(i +" : " + dsh.arr[i]);
                /*System.out.println(i +" : " + "key[" + "null" + "]" + " "
                        + "father[" + "null" + "]"  + " " +
                        "height[" + "null" + "]");*/
            } else {
                System.out.println(i + " : " + dsh.arr[i]);
            }
        }
    }
}
