package extend_test;

import lombok.extern.slf4j.Slf4j;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/17 17:30 <br>
 */
@Slf4j
public class Father {

    protected Father father;

    protected int id;

    void setFather(Father father) {
        this.father = father;
    }

    public void print() {
        log.info("father");
    }

}
