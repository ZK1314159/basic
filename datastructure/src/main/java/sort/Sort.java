package sort;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/10/22 11:29 <br>
 */
public abstract class Sort {

    public void print(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    public abstract void sort(int[] array);

}
