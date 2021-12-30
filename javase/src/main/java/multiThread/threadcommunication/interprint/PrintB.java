package main.java.multiThread.threadcommunication.interprint;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 11:01 <br>
 */
public class PrintB implements Runnable {

    private final InterPrintNumber interPrintNumber;

    public PrintB(InterPrintNumber interPrintNumber) {
        this.interPrintNumber = interPrintNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            synchronized(interPrintNumber) {
                if (!interPrintNumber.letAWork) {
                    System.out.println(Thread.currentThread().getName() + ": " + (i + 1));
                    interPrintNumber.letAWork = true;
                } else {
                    try {
                        interPrintNumber.notifyAll();
                        interPrintNumber.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
