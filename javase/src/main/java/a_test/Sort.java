package main.java.a_test;

import java.util.List;

public class Sort extends Set_Test{
    int number = 5;
    private String string = "love";
    private Set_Test test;
    private List<Integer> list;
    private int[] function(int[] ins) {
        for (int i = 1; i <= ins.length - 1; i++) {
            int tmp = ins[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (ins[j] > tmp) {
                    ins[j + 1] = ins[j];
                } else {
                    break;
                }
            }
            ins[j + 1] = tmp;
        }
        return ins;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public static void main(String[] args) {
        int[] ins = {1, 3, 4, 1, 5, 9, 2, 6, 5, 3};
        Sort s = new Sort();
        int[] ans = s.function(ins);
        for (int in : ins) {
            System.out.print(in + " ");
        }
    }
}
