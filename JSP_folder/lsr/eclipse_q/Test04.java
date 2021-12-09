package JSP_folder.lsr.eclipse_q;
/*
연습문제 1~4번 
	1. 평균 점수가 80점 이상인 학생들의 이름, 국어, 번호, 평균점수 조회
        SELECT st_name, st_kr, st_no, st_avg FROM student WHERE st_avg >= 80;
    2. '김'씨 성을 가진 학생들의 이름, 번호, 연락처를 이름 가나다순으로 조회
    3. 가장 나중에 등록한 학생 삭제
    4. 평균점수가 가장 높은 학생의 이름과 평균점수 조회
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test04 {
    public static void main(String[] args) {
        String user = "kim";
        String password = "1234";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        
        String sql_st_avg = 
        "SELECT st_name, st_kr, st_no, st_avg FROM student WHERE st_avg >= 80";
        String sql_Kim_Asc = 
        "SELECT st_name, st_no FROM student WHERE st_name like '김%' ORDER BY st_name ASC";
        String sql_Max_regdate = 
        "DELETE FROM student WHERE st_regdate = (SELECT MAX(st_regdate) FROM student";
        String sql_Max_st_avg = 
        "SELECT st_name, st_avg FROM student WHERE st_avg = (SELECT MAX(st_avg) FROM student)";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, password);
            ps = con.prepareStatement(sql_st_avg);
            rs = ps.executeQuery();

            String name;
            int kr, no;
            double avg;
            System.out.println("========== 1번 문제 ==========");
            while(rs.next()) {
                name = rs.getString("st_name");
                kr = rs.getInt("st_kr");
                no = rs.getInt("st_no");
                avg = rs.getDouble("st_avg");
                
                System.out.println("이름 : " + name);
                System.out.println("국어 : " + kr);
                System.out.println("학번 : " + no);
                System.out.println("평균점수 : " + avg + "점");
                System.out.println("");
            }
            ps.close(); rs.close();

            System.out.println("========== 2번 문제 ==========");
            ps = con.prepareStatement(sql_Kim_Asc);
            rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("이름 : " + rs.getString("st_name"));
                System.out.println("학번 : " + rs.getInt("st_no"));
                System.out.println("연락처 : " + rs.getString("st_tel"));
                System.out.println("");
            }
            ps.close(); rs.close();

            System.out.println("========== 3번 문제 ==========");
            ps = con.prepareStatement(sql_Max_regdate);
        //  System.out.println(ps.executeUpdate() + "개 레코드 삭제");
            ps.close();
        //  rs.close();

            System.out.println("========== 4번 문제 ==========");
            ps = con.prepareStatement(sql_Max_st_avg);
            rs = ps.executeQuery();

            rs.next();
            System.out.println("1등 : " + rs.getString("st_name"));
            System.out.println("점수 :  " + rs.getDouble("st_avg"));
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
