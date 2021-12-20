package multiThread.threadcommunication.interprint;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 10:41 <br>
 */
public class InterPrintNumber {

    public boolean letAWork = true;

    public static void main(String[] args) {
        InterPrintNumber interPrintNumber = new InterPrintNumber();
        PrintA printA = new PrintA(interPrintNumber);
        PrintB printB = new PrintB(interPrintNumber);
        new Thread(printA, "Thread A").start();
        new Thread(printB, "Thread B").start();
    }

}
