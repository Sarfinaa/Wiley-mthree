package PracticeQuestions;

public class Deadlock {
    String s1 = "Karan";
    String s2 = "Seth";
    Thread t1 = new Thread() {
        public void run() {
            synchronized (s1) {
                System.out.println(Thread.currentThread().getName() + " locked " + s1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s2) {
                    System.out.println(Thread.currentThread().getName() + " locked " + s2);
                    System.out.println(s1 + s2);
                }
            }

        }
    };
    Thread t2 = new Thread() {
        public void run() {
            synchronized (s2) {
                System.out.println(Thread.currentThread().getName() + " locked " + s2);
                synchronized (s1) {
                    System.out.println(Thread.currentThread().getName() + " locked " + s1);
                    System.out.println(s1 + s2);
                }
            }

        }
    };

    public static void main(String[] args) {
        Deadlock lock = new Deadlock();
        lock.t1.start();
        lock.t2.start();
    }
}
