package JSP_folder.self_Study.eclipse_q;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
/*
연습문제3
	jdbc를 사용하여 이름, 이메일을 입력받아 Account에 정보를 추가하는 클래스를 만든다.
	단, 회원번호는 acc_seq를 사용하고 적립금은 1000원, 등록일자는 SYSDATE로 지정한다.
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name, email;
        String id = "kim";
        String password = "1234";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        System.out.println("이름을 입력하세요 : ");
        name = scan.next();
        System.out.println("이메일을 입력하세요 : ");
        email = scan.next();
        String sql_insert = "insert into account2 values('" + name + "', acc_seq.NEXTVAL, '" + email
                + "', 1000, SYSDATE)"; // 다음 줄로 넘어간다면 +를 맨앞에 붙인다.
        System.out.println("확인1");
        Connection con = null;
        PreparedStatement ps = null;

        try {
            // 커넥션 연동 준비
            Class.forName("oracle.jdbc.driver.OracleDriver"); // ClassNotFountException 어ㅔ러
            con = DriverManager.getConnection(url, id, password);
            // 쿼리문 준비
            ps = con.prepareStatement(sql_insert);
            // 쿼리문 실행
            ps.execute();
            System.out.println("레코드 추가완료");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        scan.close();
    }
}