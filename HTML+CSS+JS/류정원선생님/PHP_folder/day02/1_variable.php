<?php
    $userid = "apple";
    $name = "김사과";
    $age = 20;
    $job = "학생";   
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>변수 - 1</title>
</head>
<body>
    <h2>변수 - 1</h2>

    <!-- HTML과 PHP의 주석 문법은 다르다. -->
    <?php
        /* 출력 방법1 */
        echo(" <h3>".$userid."님 안녕하세요!</h3>"); 
    ?>
    <!-- 출력 방법2 -->
    <p> 이름 : <?=$name?></p> 
    <?php
        /* 출력 방법3 */
        echo"<p>{$name}님의 나이는 {$age}살, 직업은 {$job}입니다.</p>"; 
    ?>

</body>
</html>














