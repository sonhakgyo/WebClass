package JSP_folder.tonic_project;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    private static final String id = "user";
    private static final String pw = "1234";

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
/*
    public ArrayList<MemberVO> list() {
        ArrayList<MemberVO> list = new ArrayList<MemberVO>();
        try {
        //  conDB();
            String query = "select * from Member";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                String id = rs.getString("id");
            }
        } catch(Exception e) {
            
        }
    //  return null;
    }
*/
}
