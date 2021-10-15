<?php
    $name1 = $_GET["name1"];
    $name2 = $_GET["name2"];
    $query = $_GET["q"];
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>get 방식</title>
</head>
<body>
    <h2>검색 결과</h2>
    <p>이름: <?=$name1?></p>
    <p>이름: <?=$name2?></p>
    <p>검색어: <?=$query?></p>
</body>
</html>