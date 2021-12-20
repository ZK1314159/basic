package multiThread.threadcommunication;

class ThreadCommunication extends Thread {
    private static final String st1 = "test";

    public static void main(String[] args) {
        new ThreadCommunication().start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }
        for (int i = 0; i < 26; i++) {
            System.out.print((char) (i + 65));
            try {
                synchronized (st1) {
                    st1.notifyAll();
                    st1.wait();
                }
            } catch (Exception e) {
            }
        }
    }

    public void run() {
        int in = 0;
        for (int i = 0; i < 52; i++) {
            System.out.print(i + 1);
            in++;
            if (in == 2) {
                in = 0;
                try {
                    synchronized (st1) {
                        st1.notifyAll();
                        st1.wait();
                    }
                } catch (Exception e) {
                }
            }
        }
        synchronized (st1) {
            st1.notifyAll();
        }
    }
}