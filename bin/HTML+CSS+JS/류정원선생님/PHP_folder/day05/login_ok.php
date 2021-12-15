<?php
    session_start();
    include "./include/dbconn.php";

    $userid = $_POST["userid"];
    $userpw = $_POST["userpw"];

    $sql = "SELECT mem_idx, mem_userid, mem_name FROM tb_member WHERE mem_userid='$userid' and mem_userpw=md5('$userpw')";
    $result = mysqli_query($conn, $sql);
    $row = mysqli_fetch_array($result);

    $isUserid = isset($row['mem_userid']) ? $row['mem_userid'] : '';

    if($isUserid != ''){
        $_SESSION['id'] = $userid;
        $_SESSION['idx'] = $row['mem_idx'];
        $_SESSION['name'] = $row['mem_name'];
        echo "<script>alert('로그인 되었습니다');location.href='./login.php';</script>";
    }else{
        echo "<script>alert('로그인 실패! 아이디 또는 비밀번호를 확인하세요');history.back();</script>";
    }
?>