<?php
$arr = array("김사과", "반하나", "오렌지", "이메론");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>배열</title>
</head>
<body>
    <h2>배열</h2>
<!-- 빨간색 텍스트인 이유는 html5에서 추천하지 않기 때문이다. -->
    <table border="1" width="300">
<?php
    foreach ($arr as $name) {
        /* $arr 배열 수만큼 반복한다. */
        /* $arr[0] 순서대로 $name에 저장하는 반복문 */
        /* 때문에 4행의 테이블이 생긴다. */
?>
    <tr>
        <td><?= $name ?></td>
    </tr>
<?php
    }
?>
    </table>
</body>
</html>