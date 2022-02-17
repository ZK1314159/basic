package extend_test;

import lombok.extern.slf4j.Slf4j;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/17 17:30 <br>
 */
@Slf4j
public class Sun extends Father {

//    private Father father;

    void setFather(Father father) {
        this.father = father;
    }

    public void print() {
        Father handler1 = super.father;
        log.info(handler1 == null ? null : handler1.toString());
        Father handler2 = this.father;
        log.info(handler2 == null ? null : handler2.toString());
        int id = this.id;
        int id2 = super.id;
        log.info(String.valueOf(id2));
    }

}
