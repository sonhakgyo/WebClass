<?php
    /* 함수 선언 */
    function counter(){
        static $count1 = 1;
        $count2 = 1;
        echo "<p>static 변수 count1의 값: {$count1}</p>";
        echo "<p>기본변수 count2의 값: {$count2}</p>";
        $count1++;
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>변수 - 3</title>
</head>
<body>
    <h2>변수 - 3</h2>
    <?php
        counter();
        counter();
        counter();
        counter();
        counter();
        counter();
        counter();
        counter();
        counter();
        counter();
        counter();
        counter();
    ?>
</body>
</html>