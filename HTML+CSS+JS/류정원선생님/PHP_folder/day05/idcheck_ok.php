<?php
    include "./include/dbconn.php";

    $userid = $_GET['userid'];

    $sql = "select mem_idx from tb_member where mem_userid='$userid'";
    $result = mysqli_query($conn, $sql);

    $row = mysqli_fetch_array($result);

    $isuserid = isset($row['mem_idx']) ? $row['mem_idx'] : '';

    if($isuserid == ""){
        echo "success";
    }else{
        echo "fail";
    }
?>