package javase;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/15 14:06 <br>
 */
public class SwitchTest {
    public static void main(String[] args) {
        int i = 3;
        switch (i) {
            case 3:
                System.out.println(i);
                break;
            case 4:
                System.out.println(i + 3);
                break;
            default:
                System.out.println("default");
        }

        int j = 0;
        do {
            System.out.println("do while loop " + j + " ");
            j++;
        }
        while (j < 10);
    }
}
