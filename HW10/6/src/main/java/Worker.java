import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Worker extends Thread {

    public synchronized void work() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is working");
        }
    }
}