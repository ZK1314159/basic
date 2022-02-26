package singleton;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/26 17:12 <br>
 */
public enum Test {

    INSTANCE;

    private int id = 2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        int id = Test.INSTANCE.getId();
        Test.INSTANCE.setId(4);
        int newId = Test.INSTANCE.getId();
    }

}
