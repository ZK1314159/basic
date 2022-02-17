package chain;

import lombok.extern.slf4j.Slf4j;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/17 15:42 <br>
 */
@Slf4j
public abstract class Handler {

    protected Handler higherUp;

    void setHigherUp(Handler higherUp) {
        this.higherUp = higherUp;
    }

    abstract void handle(Request request);

    public void print() {
       log.info("father");
    }

}
