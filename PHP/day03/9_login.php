<?php
    session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<body>
    <?php
        if(!isset($_session['ID'])){
    ?>
    <h2>로그인</h2>
    <form method="get" action="4_get_ok.php">
        <p>아이디: <input type="text" name="userid"></p>
        <p>비밀번호: <input type="search" name="userpw"></p>
        <p><input type="submit" value="검색"></p>
    </form>
    <?php
        }else{
    ?>
        <p><?$_SESSION['id']?>님 환영합니다.</p>
        <p><a href="./9_logout.php">로그아웃</a></p>
    <?php
        }
    ?>
</body>
</html>