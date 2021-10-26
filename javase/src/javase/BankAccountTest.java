package javase;

import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.yield;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/15 19:41 <br>
 */
public class BankAccountTest {
    public static void main(String[] args) {
        Account account = new Account(123455, 1000);
        new Thread(new drawThread(account), "draw").start();
        new Thread(new depositThread(account), "deposit").start();
        //ThreadPoolExecutor
    }
}

class drawThread implements Runnable {
    Account account;

    drawThread(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            account.draw();
        }
    }
}

class depositThread implements Runnable {
    Account account;

    depositThread(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            account.deposit();
        }
    }
}

class Account {
    int accountNum;
    double money;

    Account(int accountNum, double money) {
        this.accountNum = accountNum;
        this.money = money;
    }

    public synchronized void draw() {
        try {
            if (money < 500) {
                wait();
            }
            else {
                money -= 500;
                System.out.println(Thread.currentThread().getName() + ": " + money);
                if (money < 2000) {
                    notifyAll();
                    wait();
                }
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void deposit(){
        try {
            if (money > 2000) {
                wait();
            }
            else {
                money += 250;
                System.out.println(Thread.currentThread().getName() + ": " + money);
                if (money >= 500) {
                    notifyAll();
                    wait();
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



