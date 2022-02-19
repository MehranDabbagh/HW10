import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Connection connection=PostgresConnection.getInstance().getConnection();
        File file = new File("C:/USERS/ASUS/DESKTOP/New Folder/sa.txt");
        Scanner scanner = new Scanner(file);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        while(scanner.hasNextLine()){
           executorService.submit(new InsertThread(connection,scanner.nextLine()));
        }
executorService.shutdown();
    }
}
