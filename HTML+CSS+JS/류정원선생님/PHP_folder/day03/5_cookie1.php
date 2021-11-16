<?php
/* 만료시간 time() + (60 * 3)은 현재 시간에서 180초 후에 만료한다는 의미이다. */
    setcookie("userid", "apple", time() + (60*3), "/");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쿠키 만들기</title>
</head>
<body>
    <h2>쿠키 만들기</h2>
</body>
</html>