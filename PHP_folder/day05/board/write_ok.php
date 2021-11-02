<?php
    include "../include/sessioncheck.php";
    include "../include/dbconn.php";

    $userid = $_SESSION['id'];
    $b_title = $_POST['b_title'];
    $b_content = $_POST['b_content'];

    $sql = "insert into tb_board (b_userid, b_title, b_content) values ('$userid', '$b_title', '$b_content')";
    //echo $sql;
    $result = mysqli_query($conn, $sql);

    echo "<script>alert('저장되었습니다'); location.href='./list.php';</script>";
?>