<?php
session_sta rt();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>세션 - 2</title>
</head>
<body>
    <h2>세션 - 2</h2>
    <p>세션 id : <?= session_id() ?></p>
    <p>세션 id의 변수 userid값 : <?= $_SESSION['userid'] ?></p>
    <p>세션 id의 변수 name값 : <?= $_SESSION['name'] ?></p>
</body>
</html>