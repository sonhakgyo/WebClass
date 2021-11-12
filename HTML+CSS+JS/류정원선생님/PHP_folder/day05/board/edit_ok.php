<?php
    include "../include/sessioncheck.php";
    include "../include/dbconn.php";

    $b_idx          = $_POST['b_idx'];
    $b_title        = $_POST['b_title'];
    $b_content      = $_POST['b_content'];

    $sql = "update tb_board set b_title='$b_title', b_content='$b_content' where b_idx=$b_idx";
    $result = mysqli_query($conn, $sql);

    echo "<script>alert('수정되었습니다');location.href='./detail.php?b_idx=".$b_idx."';</script>";
