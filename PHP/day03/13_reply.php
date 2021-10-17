<?php
if ($_POST != null) {
    // 댓글을 썼다면...
    $fs = @fopen("reply.txt", "a") or exit("break");
    if ($fs != null) {
        $msg = $_POST['msg'];
        fputs($fs, $msg . "\n");
        fclose($fs);
    }
}

$result = "";
$fs = @fopen("reply.txt", "r") or exit("break");
$i = 1;
while (!feof($fs)) {
    $msg = fgets($fs);
    if ($msg != "") {
        $result = $i++ . " > " . $msg . "<br>" . $result;
    }
}
fclose($fs);

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>파일을 이용한 댓글</title>
</head>
<body>
    <h2>파일을 이용한 댓글</h2>
    <form action="./13_file4.php" method="post">
        <p><label>댓글 : <input type="text" name="msg"></label> <input type="submit" value="확인"></p>
    </form>
    <hr />
    <p><?= $result ?></p>
</body>
</html>