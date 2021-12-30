package main.java.disjointset;

public class DisjointSet {
    private int[] arr;
    private static final int size = 10;

    public DisjointSet() {
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = -1;
        }
    }

    private void union(int root1, int root2) {
        if (arr[root1] < arr[root2]) {
            arr[root2] = root1;
        } else {
            if (arr[root1] == arr[root2]) {
                arr[root2]--;
            }
            arr[root1] = root2;
        }
    }

    private int find(int t) {
        if (arr[t] < 0) {
            return t;
        }
        return arr[t] = find(arr[t]);
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();
        for (int i : ds.arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int in1 = ds.find(2);
        //System.out.println(in1);
        int in2 = ds.find(3);
        //System.out.println(in2);
        ds.union(ds.find(5), ds.find(7));
        ds.union(ds.find(7), ds.find(9));
        ds.union(ds.find(3), ds.find(4));
        ds.union(ds.find(2), ds.find(3));
        ds.union(ds.find(4), ds.find(7));
        ds.find(3);
        ds.find(2);
        for (int i : ds.arr) {
            System.out.print(i + " ");
        }
    }
}
