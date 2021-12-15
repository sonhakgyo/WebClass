<?php
    function hello(){
        echo "<p>Hello PHP!</p>";
    }

    function sum($num1, $num2){
        echo "<p>{$num1} + {$num2} = ".($num1 + $num2)."</p>";
    }

    function getSum($num1, $num2){
        return $num1 + $num2;
    }
?>