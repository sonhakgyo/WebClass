<?php
    include "../include/sessioncheck.php";
    include "../include/dbconn.php";

    $b_idx = $_GET['b_idx'];

    $sql = "delete from tb_board where b_idx=$b_idx";
    $result = mysqli_query($conn, $sql);
    echo "<script>alert('삭제되었습니다');location.href='list.php';</script>";
?>