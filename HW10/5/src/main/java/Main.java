public class Main{
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object() ;
        Thread t1 = new Thread() {
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread 1: locked By lock1");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (lock2) {
                        System.out.println("Thread 1:locked by lock2");
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized (lock2) {
                    System.out.println("Thread 2: locked by lock2");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (lock1) {
                        System.out.println("Thread 2: locked By lock1");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
