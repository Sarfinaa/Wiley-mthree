package week_3.multithreading;

class evenodd {
    int i = 0;
    static int limit = 50;

    synchronized void printEven() throws InterruptedException {
        while (i <= limit) {
            if (i % 2 == 0) {
                System.out.println("Even:" + i++);
                notifyAll();
            } else
                wait();
        }
    }

    synchronized void printOdd() throws InterruptedException {
        while (i <= limit) {
            if (i % 2 != 0) {
                System.out.println("Odd:" + i++);
                notifyAll();
            } else
                wait();

        }
    }
}

public class EvenOddThread {
    public static void main(String[] args) {
        evenodd eo = new evenodd();
        new Thread() {
            public void run() {
                try {
                    eo.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    eo.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
