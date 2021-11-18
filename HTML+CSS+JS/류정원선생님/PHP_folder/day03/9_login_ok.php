<?php
    session_start();
    $userid = $_POST["userid"];
    $userpw = $_POST["userpw"];

    if ($userid == "admin" && $userpw == "1234") {
        $userid = $_POST["userid"];
        // $_SESSION['id'] = $userid;
        echo 
        "<script>
            alert('로그인 되었습니다.');
            location.href='./9_login.php';
        </script>";
    } else {
        echo 
        "<script>
            alert('로그인 실패! 아이디 또는 비밀번호를 확인하세요!');
            history.back();
        </script>";
    }
?>