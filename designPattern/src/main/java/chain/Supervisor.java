package chain;

import lombok.extern.slf4j.Slf4j;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/17 15:47 <br>
 */
@Slf4j
public class Supervisor extends Handler {

    @Override
    public void handle(Request request) {
        log.info("Supervisor: handle success!");
    }

}
