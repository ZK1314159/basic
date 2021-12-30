package multiThread.other.bank;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/8/6 17:14 <br>
 */
public class BankTest {

    public static void main(String[] args) {
        Account account = new Account(1000);
        SaveMoney saveMoney = new SaveMoney(account);
        DrawMoney drawMoney = new DrawMoney(account);
        for (int i = 0; i < 10; i++) {
            new Thread(drawMoney, "drawThread " + i + ": ").start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(saveMoney, "saveThread " + i + ": ").start();
        }
    }
}
