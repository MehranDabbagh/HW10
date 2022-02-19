import java.io.File;

public class FindingSize {
    public void run(String address,Integer amount){
        File folder=new File(address);
        File[] listOfFiles=folder.listFiles();
        ThreadWorker[] threadWorkers=new ThreadWorker[amount];
        long totalSpace =0L;
        int threadCounter=0;
        for (int i = 0; i <amount ; i++) {
            threadWorkers[i]=new ThreadWorker();
        }
        for (int i = 0; i < listOfFiles.length ; i++) {
            threadWorkers[threadCounter].setFile(listOfFiles[i]);
            threadCounter++;
            if(threadCounter>amount-1){
                threadCounter=0;
            }
        }
        for (int i = 0; i <amount ; i++) {
            threadWorkers[i].run();
        }

        for (int i = 0; i <amount ; i++) {
            totalSpace +=threadWorkers[i].getResult();
        }

        System.out.println(totalSpace);



    }
}
