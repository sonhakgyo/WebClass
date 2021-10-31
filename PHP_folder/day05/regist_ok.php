<?php
include "./include/dbconn.php";

$userid = $_POST["userid"];
$userpw = $_POST["userpw"];
$name   = $_POST["name"];
$hp     = $_POST["hp"];
$email  = $_POST["email"];
$hobby  = $_POST["hobby"];  // ['영화감상','쇼핑']
$hobbystr = "";
foreach ($hobby as $h) {
    $hobbystr .= $h . " ";
}
$ssn1   = $_POST["ssn1"];
$ssn2   = $_POST["ssn2"];
$zipcode = $_POST["zipcode"];
$address1 = $_POST["address1"];
$address2 = $_POST["address2"];
$address3 = $_POST["address3"];

$sql = "INSERT INTO tb_member (mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_hobby, mem_ssn1, mem_ssn2, mem_zipcode, mem_address1, mem_address2, mem_address3) VALUES ('$userid', md5('$userpw'), '$name', '$hp', '$email', '$hobbystr', '$ssn1', '$ssn2', '$zipcode', '$address1', '$address2', '$address3')";

// echo $sql;
$result = mysqli_query($conn, $sql);
?>
<script>
    alert('회원가입 성공!');
    location.href = "./login.php";
</script>