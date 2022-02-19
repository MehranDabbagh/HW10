public class BackgroundThread extends Thread{
   private boolean flag=true;
public void run(){
    while(flag){

        System.out.println("Hello!");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    public  void exit(){
            this.flag=false;

    }
}
