import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertThread implements Runnable{
    private Connection connection;
    private String line;
    private final  String sql="insert into words (word) values (?)";
    public InsertThread(Connection connection,String line) {
        this.connection = connection;
        this.line=line;
    }

    @Override
    public void run() {

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            String[] words=line.split(" ");
            for (String word: words
                 ) {
                if(word!=null && word.length()>1){
                    preparedStatement.setString(1,word);
                    preparedStatement.execute();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
