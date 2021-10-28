<?php
    $num = 10;
    /* 함수 선언 */
    function func1() {
        $str = "PHP";
        echo "<p>함수 안에서 호출한 지역변수 str의 값 : {$str}</p>";
        global $num;
        echo "<p>함수 안에서 호출한 전역변수 num의 값 : {$num}</p>";
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>변수 - 2</title>
</head>
<body>
    <h2>변수 - 2</h2>

    <?php
        func1();
        /* 함수 외부에서도 출력되는지 확인 */
        echo "<p>함수 밖에서 호출한 전역변수 num의 값: {$num}</p>";
    ?>
</body>
</html>