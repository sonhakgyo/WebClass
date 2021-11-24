package JSP_folder.Self_Study.연습문제1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/*
연습문제2
	jdbc를 사용하여 Account 테이블에 3개의 레코드를 임의로 추가하는 클래스 만들기
	단, 회원번호는 acc_seq를 사용한다.
*/
public class Test02 {
    public static void main(String[] args) {
        String id = "user";
        String password = "1234";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String sql_insert1 = "insert into account values('김종혁', acc_seq.NEXTVAL, 'totls0121@naver.com', 7000, sysdate)";
        String sql_insert2 = "insert into account values('류상현', acc_seq.NEXTVAL, 'fbtkdgus111@naver.com', 8000, sysdate)";
        String sql_insert3 = "insert into account values('김지나', acc_seq.NEXTVAL, 'geee_na@naver.com', 9000, sysdate)";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, id, password);
            // 세 개의 레코드 추가
            ps = con.prepareStatement(sql_insert1);
            ps.execute();
            ps = con.prepareStatement(sql_insert2);
            ps.execute();
            ps = con.prepareStatement(sql_insert3);
            ps.execute();
            System.out.println("레코드 추가완료");
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            try {
                if (con != null) { con.close(); }
                if (ps != null) { ps.close(); }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
