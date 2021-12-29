package proxy;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/29 19:58 <br>
 */
public class NormalServiceImpl implements NormalService{

    @Override
    public Integer test(Integer id) {
        System.out.println("core method , id = " + id);
        return id;
    }

    @Override
    public String toString() {
        System.out.println("find toString code!!!");
        return "find toString ";
    }

}
