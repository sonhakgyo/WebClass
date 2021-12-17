<?php
    $userid = $_POST["userid"];
    $userpw = $_POST["userpw"];
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>post 방식</title>
</head>
<body>
    <h2>로그인</h2>
    <p>아이디: <?=$userid?></p>
    <p>비밀번호: <?=$userpw?></p>
</body>
</html>