package JSP_folder.self_Study.eclipse_q;

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
        String sql_insert1 = "insert into account values('김종혁', acc_seq.NEXTVAL, 'totls0121@naver.com', 7000, SYSDATE)";
        String sql_insert2 = "insert into account values('류상현', acc_seq.NEXTVAL, 'fbtkdgus111@naver.com', 8000, SYSDATE)";
        String sql_insert3 = "insert into account values('김지나', acc_seq.NEXTVAL, 'geee_na@naver.com', 9000, SYSDATE)";

        //  ps1~3까지 만들 필요없이 ps 변수 하나만 있어도 되지만 깔끔하게 하기 위해서 만들었다.
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Connection con = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, id, password);
            // 세 개의 레코드 추가
            ps1 = con.prepareStatement(sql_insert1);
            ps1.execute();
        //  Resource leak: 'ps' is not closed at this location : ps가 아직 종료되지 않았다.
        //  무시해도 되는 에러지만 깔끔하게 ps2, ps3 변수까지 만든다.
            ps2 = con.prepareStatement(sql_insert2); 
            ps2.execute();
            ps3 = con.prepareStatement(sql_insert3);
            ps3.execute();
            System.out.println("레코드 추가완료");
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            try {
                if (con != null) { con.close(); }
                if (ps1 != null) { ps1.close(); }
                if (ps2 != null) { ps2.close(); }
                if (ps3 != null) { ps3.close(); }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
