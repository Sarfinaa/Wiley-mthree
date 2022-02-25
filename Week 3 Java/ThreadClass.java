class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format("5 * %d = %d", i, 5 * i));
        }
        System.out.println("Thread1 Terminated!!!");
    }
}

class Thread2 implements Runnable {
    @Override
    synchronized public void run() {
        String[] countries = { "INDIA", "USA", "RUSSIA", "UK", "CANADA" };
        for (String str : countries) {
            System.out.println(str + " ");
        }
        System.out.println();
        System.out.println("Thread2 Terminated!!!");
    }
}

public class ThreadClass {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 thread = new Thread2();
        Thread1 t2 = new Thread1();
        System.out.println("Main Thread Started!!!");
        t1.start();
        t2.start();
        // System.out.println("Name: Karan Seth");
        // System.out.println("Location: New Delhi");
        // System.out.println("Hobby: Gaming");
        // System.out.println("Main Thread Terminated!!");

    }
}