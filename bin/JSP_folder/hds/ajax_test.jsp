<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//	파라미터를 가져와 데이터를 DB의 member 테이블 레코드로 추가(회원등록) 
//	이후 결과페이지(joinResultView.jsp)로 페이지 이동
	String id = request.getParameter("user_id");
	String password = request.getParameter("user_password");
	String email = request.getParameter("user_email1")+"@"+request.getParameter("user_email2");
	String nickname = request.getParameter("user_nickname");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "user";
	String userPassword = "1234";
	String sql = "INSERT INTO member VALUES(member_seq.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
//  여기서부터 다시 작성
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>