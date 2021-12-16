package multiThread.test.example.bank;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/8/6 17:16 <br>
 */
public class DrawMoney implements Runnable {

    Account account;

    DrawMoney(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {
            try {
                while (account.deposit < 400) {
                    System.out.println(Thread.currentThread().getName() + ": Money is not enough, I'm waiting! "
                            + System.currentTimeMillis());
                    account.wait();
                }
                account.deposit -= 400;
                System.out.println(Thread.currentThread().getName() + ": draw $400! " + System.currentTimeMillis());
                account.notifyAll();
            } catch (InterruptedException e) {}
        }
    }
}
