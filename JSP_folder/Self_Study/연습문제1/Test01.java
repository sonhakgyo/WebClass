package JSP_folder.Self_Study.연습문제1;
/*
연습문제 
	jdbc를 사용하여 회원들의 정보를 저장할 Account 테이블을 생성하는 클래스 만들기
	다음과 같은 항목이 있어야 한다.
		이름
		이메일
		적립금
		번호
		가입날짜
	또한, acc_seq라는 시퀀스도 생성해야 한다.
*/
import java.sql.*;

public class Test01 {
	public static void main(String[] args) {
		String id = "user";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql_table = "CREATE TABLE account"
					+"("
					+"name VARCHAR2(20),"
					+"no NUMBER,"
					+"email VARCHAR2(20),"
					+"point NUMBER,"
					+"regdate DATE"
					+")";
		String sql_sequence = "CREATE SEQUENCE acc_seq NOCACHE";
		
	//  초기화는 null까지 넣어줘야 한다. 
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, password);
			
		//  Account 테이블 생성
			ps = con.prepareStatement(sql_table);
			ps. execute();
			System.out.println("Account 테이블 생성완료");
			
		//  acc_seq 시퀀스 생성
			ps = con.prepareStatement(sql_sequence);
			ps.execute();
			System.out.println("acc_seq 시퀀스 생성완료");
		} catch(Exception e) {
			e.printStackTrace();
		} finally { // 예외상황이 발생했던 안 했던 간에 무조건 실행하는 구문
			try {
				if (ps != null) {
					ps.close();  // null.close(); NullPointerException
				}
				if ( con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}