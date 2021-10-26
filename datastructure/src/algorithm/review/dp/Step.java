package algorithm.review.dp;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/29 14:09 <br>
 */
public class Step {
    int count(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        int fn = 3;
        for (int i = 3; i <= n; i++) {
            fn = f2 + f1;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        Step test = new Step();
        //45已经接近int的上限
        System.out.println(test.count(45));
    }
}
