<?php
    include "./day03/function.php"
?>
<!DOCTYPE html>
<html lang="en">
<head>
<?php
    include "./layout/head.php"
?>
</head>
<body>
    <h2>함수</h2>
    <?php
    hello(); 
    hello();

    sum(10, 3);
    sum(5, 2);

    $result = getSum(10, 5);
    echo "result : {$result}";
    ?>
</body>
</html>