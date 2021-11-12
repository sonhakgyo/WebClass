<?php
$count = $_POST["count"];
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>테이블 만들기</title>
    <style>
        table {
            border: 3px solid red;
        }

        td {
            text-align: center;
            width: 300px;
            border: 3px solid red;
        }
    </style>
</head>

<body>
    <h2>테이블 만들기</h2>
    <table>
        <?php
        for ($i = 1; $i <= $count; $i++) {
        ?>
            <tr>
                <td><?= $i ?>번째 셀</td>
            </tr>
        <?php
        }
        ?>
    </table>
</body>

</html>