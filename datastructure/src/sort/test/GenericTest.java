package sort.test;

/**
 * Description：<br>
 *
 * @author zeng.kai <br>
 * CreateDate：2019/10/23 10:26 <br>
 */
public class GenericTest<K> {
    /**
     * Description: 只能处理父类的方法和变量 <br>
     *
     * @author zeng.kai <br>
     * CreateDate: 2019/10/23 11:00 <br>
     */
    private <T extends Parent> T testGeneric(T object) {
        object.number = 4;
        return object;
    }

    //@SensitiveInfo
    private K parent;

    public K getParent() {
        return parent;
    }

    public void setParent(K parent) {
        this.parent = parent;
    }

    public static void main(String[] args) {
        GenericTest test = new GenericTest();
        Child child = new Child();
        System.out.println(test.testGeneric(child).number);
    }
}
