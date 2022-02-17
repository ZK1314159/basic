package chain;

import lombok.extern.slf4j.Slf4j;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/17 15:47 <br>
 */
@Slf4j
public class GroupLeader extends Handler {

    @Override
    public void handle(Request request) {
        if ("leave".equals(request.getReason()) && request.getNumber() <= 3) {
            log.info("GroupLeader: agree to leave");
        } else {
            if (higherUp != null) {
                higherUp.handle(request);
            } else {
                log.info("GroupLeader: can not handle it");
            }
        }
    }

}
