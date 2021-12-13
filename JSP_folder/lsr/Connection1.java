package JSP_folder.lsr;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

/*
<자바 쿼리문 실행>
1. 연결(Connection)
2. 쿼리문 준비(PreparedStatement)
3. 실행(Exccute())
4. 정리(Close())
*/

public class Connection1 { // 1을 빼면 생성자가 되어버린다.
    public static void main(String[] args) {
        String id = "kim";
        String password = "1234";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String sql_Create = "CREATE SEQUENCE student_seq NOCACHE";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // ClassNotFoundException
        //  Class.forName(클래스명) : 클래스를 찾는다. 찾고난 후에 클래스를 로드한다.
        //  클래스 로드 : 프로그램 시작 전에 프로그램이 필요한 해당 클래스를 메모리에 미리 준비하는 작업이다.
        //  Connection 인터페이스
            Connection con = (Connection) DriverManager.getConnection(url, id, password); 
        //  Connection : 다리 역할의 객체(객체끼리 연결해준다. .java -- Oracle, DB)
            PreparedStatement ps = con.prepareStatement(sql_Create);

            ps.execute();
            
            ps.close();
            con.close();

            System.out.println("시퀀스 생성 완료");

        } catch (ClassNotFoundException e) { // OracleDriver 클래스가 없을 때 발생한다.
            e.printStackTrace();
        } catch (SQLException e) { // 커넥션(DB연동)하는 과정에서 발생한다.
            e.printStackTrace();
        }
    }
}
