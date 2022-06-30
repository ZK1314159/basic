package algorithm.other;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/29 23:42 <br>
 */
public class CalculateVelocity {

    public double calculate(int weight, int height) {
        // 用数值计算代替积分
        double h = height;
        int gridNumber = 10000;
        double g = 9.80665;
        double k = 0.24;
        double a = g;
        double v = 0;
        while (h >= 0) {
            v += a / gridNumber;
            h -= v / gridNumber;
            a = (weight * g - k * (v * v)) / weight;
        }
        return v;
    }

    public static void main(String[] args) {
        CalculateVelocity test = new CalculateVelocity();
        int weight = 600;
        for (int i = 10; i <= 1000; i +=20) {
            double v = test.calculate(weight, i);
            System.out.println("高度: " + i + ", 速度：" + v);
        }
    }

}
