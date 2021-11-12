<?php
    $conn = mysqli_connect("127.0.0.1", "root", "1234", "frontend") or die("데이터베이스 연결 실패!");

    if($conn){
        echo("DB연결 성공!");
    }else{
        echo("🤬");
    }
