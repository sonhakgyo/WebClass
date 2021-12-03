package JSP_folder.self_Study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultSet1 {
    public static void main(String[] args) {
        String id = "kim";
        String password = "1234";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

    //  커넥션 준비
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, id, password);

            String sql_Select = "SELECT st_name, st_avg FROM student";
            ps = con.prepareStatement(sql_Select);
            rs = ps.executeQuery();

        //  boolean result = rs.next(); // 레코드가 1개라도 있으면 true, 없으면 false
                                        // 레코드를 확인하기 위해서는 최소 1회 next()를 실행해야 한다.
                                        // 실행하지 않은 초기 커서는 아무 것도 가리키지 않기 때문이다.

            while(rs.next()) { // 레코드가 남아있을 동안 반복한다.
                String name; 
                name = rs.getString("st_name"); // 현재 위치 레코드의 st_name 열의 값을 String 형태로 가져온다.
                double avg; 
                avg = rs.getDouble("st_avg");   // 현재 위치 레코드의 st_avg 열의 값을 double 형태로 가져온다.
                                                // getString("String") : 항목 이름
                                                // getDouble(int) : 몇 번째 항목 <-- 항목 이름을 모를 때
                                                // getInt();
                                                // getBoolean();
                System.out.println(name + "/" + avg + "점");
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps != null) ps.close();
                if(con != null) con.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
