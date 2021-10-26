package a_prepare;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int i = in.nextInt();
            if (i == -1) {
                break;
            } else {
                list.add(i);
            }
        }
        //System.out.print();
    }
}
