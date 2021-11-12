<?php
    session_start();
    if(!isset($_SESSION['idx'])){
        echo "<script>alert('잘못된 접근입니다. 로그인하세요'); location.href='../login.php';</script>";
    }
?>