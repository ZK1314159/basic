package extend_test;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/17 17:30 <br>
 */
public class Test {

    public static void main(String[] args) {
        Father father = new Father();
        father.id = 7;
        Sun sun = new Sun();
        sun.setFather(father);
        sun.id = 3;
        sun.print();
    }

}
