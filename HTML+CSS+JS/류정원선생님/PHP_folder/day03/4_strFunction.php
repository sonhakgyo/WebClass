<?php
    $str1 = "abcdefghijklmn12345";
    $str2 = "가나다라마바사아자차카타파하"; // php에서 한글은 3바이트!
    $str3 = "Hello/PHP/Hello/World";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문자열 함수</title>
</head>
<body>
    <h2>문자열 함수</h2>
    <?php 
        echo strlen($str1)."<br>";
        echo strlen($str2)."<br>";
        echo strlen($str3)."<br>";

        echo "<br>";

        echo strcmp("abc", "ABC")."<br>";
        echo strcmp("10", "2")."<br>";
/*      strcmp()
            - 전달 받은 두 개의 문자열을 서로 비교
            - 첫번째 매개변수가 두번째 매개변수보다 크면 양수, 작으면 음수를 반환
            - 같으면 0을 반환 
*/
        echo strstr($str1, "cd")."<br>";
        echo "<br>";

        echo strpos($str1, "abc")."<br>";
        echo "<br>";

        echo substr($str1, 3)."<br>";
        echo substr($str1, -3)."<br>";
        echo substr($str1, 3, 10)."<br>";

        $arr = explode("/", $str3);
        foreach($arr as $str){
            echo $str." ";
        }

        echo("<br>");
        echo str_replace("o", "💎", $str3)."<br>";
    ?>
</body>
</html>