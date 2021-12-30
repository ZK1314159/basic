package main.java.multiThread.threadcommunication.interprint;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 11:01 <br>
 */
public class PrintA implements Runnable {

    private final InterPrintNumber interPrintNumber;

    public PrintA(InterPrintNumber interPrintNumber) {
        this.interPrintNumber = interPrintNumber;
    }

    @Override
    public void run() {
        synchronized(interPrintNumber) {
            for (int i = 0; i < 100; i++) {
                if (interPrintNumber.letAWork) {
                    System.out.println(Thread.currentThread().getName() + ": " + (i + 1));
                    interPrintNumber.letAWork = false;
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
