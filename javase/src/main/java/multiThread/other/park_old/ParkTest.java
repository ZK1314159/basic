package main.java.multiThread.other.park_old;

class ParkIn implements Runnable {
    private final Car car;

    ParkIn(Car car) {
        this.car = car;
    }

    public void run() {
        synchronized (car) {
            boolean[] bo = new boolean[3];
            bo = car.getbo();
            for (int i = 0; i < 3; i++) {
                if (!bo[i]) {
                    bo[i] = true;
                    car.setbo(bo);
                    System.out.println(Thread.currentThread().getName() + "停车成功！");
                    return;
                }
            }
            System.out.println(Thread.currentThread().getName() + "发现没有车位可以停！");
        }
    }
}

class ParkOut implements Runnable {
    private final Car car;

    ParkOut(Car car) {
        this.car = car;
    }

    public void run() {
        synchronized (car) {
            boolean[] bo = new boolean[3];
            bo = car.getbo();
            for (int i = 0; i < 3; i++) {
                if (bo[i]) {
                    bo[i] = false;
                    car.setbo(bo);
                    System.out.println(Thread.currentThread().getName() + "驾车离开！");
                    return;
                }
            }
            System.out.println(Thread.currentThread().getName() + "发现没有车可以开走！");
        }
    }
}

class Car {
    private boolean[] bo = new boolean[3];

    void setbo(boolean[] bo) {
        this.bo = bo;
    }

    boolean[] getbo() {
        return bo;
    }
}

public class ParkTest {
    public static void main(String[] args) {
        Car car = new Car();
        ParkIn in = new ParkIn(car);
        ParkOut out = new ParkOut(car);
        new Thread(in, "张1").start();
        new Thread(in, "张3").start();
        new Thread(in, "张2").start();
        new Thread(in, "张4").start();
        new Thread(in, "张5").start();
        new Thread(in, "张6").start();
        new Thread(in, "张7").start();
        new Thread(in, "张8").start();
        new Thread(in, "张9").start();
        new Thread(out, "李1").start();
        new Thread(out, "李2").start();
        new Thread(out, "李3").start();
        new Thread(out, "李4").start();
        new Thread(out, "李5").start();
        new Thread(out, "李6").start();
        new Thread(out, "李7").start();
        new Thread(out, "李8").start();
        new Thread(out, "李9").start();
    }
}
      