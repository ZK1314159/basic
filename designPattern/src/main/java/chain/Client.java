package chain;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/17 15:42 <br>
 */
public class Client {

    public static void main(String[] args) {
        Request request = new Request();
        request.setId(1);
        request.setName("fdjf");
        request.setReason("leave");
        request.setNumber(4);
        Handler groupLeader = new GroupLeader();
        Handler supervisor = new Supervisor();
        groupLeader.setHigherUp(supervisor);
        groupLeader.print();
        groupLeader.handle(request);
    }

}
