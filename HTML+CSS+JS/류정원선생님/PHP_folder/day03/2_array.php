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
    <table border = "1" width = "300">
<?php     
    foreach($arr as $name){
?>
        <tr>
            <td><?=$name?></td>
        </tr>
<?php    
    }
?>    
    </table>
</body>
</html>