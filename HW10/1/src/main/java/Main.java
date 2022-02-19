public class Main {
    public static void main(String[] args) {

     Thread backgroundThread=new BackgroundThread();
     backgroundThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         ((BackgroundThread) backgroundThread).exit();
        System.out.println("Interrupted");


    }
}
