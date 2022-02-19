import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class ThreadWorker implements Runnable{
    private ArrayList<File> files=new ArrayList<>();
    private Long totalSpace=0L;
    CountDownLatch latch=new CountDownLatch(0);

    public ThreadWorker() {
    }

    public void setFile(File file){
        this.files.add(file);
}
    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(files.size()>0) {
            for (File file : files
            ) {
                totalSpace += file.length();
            }
        }
    }
    public Long getResult(){
        return totalSpace;
    }
}
