package multiThread.example.bank;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/8/6 17:16 <br>
 */
public class SaveMoney implements Runnable {

    Account account;

    SaveMoney(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {
            try {
                while (account.deposit > 2000) {
                    System.out.println(Thread.currentThread().getName() + ": Money is too much, I'm waiting! "
                            + System.currentTimeMillis());
                    account.wait();
                }
                account.deposit += 800;
                System.out.println(Thread.currentThread().getName() + ": save $800! " + System.currentTimeMillis());
                account.notifyAll();
            } catch (InterruptedException e) {}
        }
    }
}
