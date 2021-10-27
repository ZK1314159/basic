package algorithm.dp;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/10/27 20:17 <br>
 */
public class StepNew {

    private long count(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long fn_1 = 1;
        long fn = 1;
        for (int i = 2; i <= n; i++) {
            long tmp = fn;
            fn = fn + fn_1;
            fn_1 = tmp;
        }
        return fn;
    }

    public static void main(String[] args) {
        StepNew stepNew = new StepNew();
        long result = stepNew.count(45); // 1836311903
        System.out.println(result);
    }

}
