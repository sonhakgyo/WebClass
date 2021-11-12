<?php
include "../include/sessioncheck.php";
include "../include/dbconn.php";

if (!isset($_GET['b_idx'])) {
    echo "<script>alert('잘못된 접근입니다');location.href='./list.php';</script>";
};

$b_idx = $_GET['b_idx'];

// 조회수 1올리기
$sql = "update tb_board set b_hit = b_hit + 1 where b_idx=$b_idx";
$result = mysqli_query($conn, $sql);

// 글보기
$sql = "select b_idx, b_title, b_content, b_userid, b_hit, b_regdate, b_like from tb_board where b_idx=$b_idx";
$result = mysqli_query($conn, $sql);
$row = mysqli_fetch_array($result);

$id         = $_SESSION['id'];  // 로그인된 아이디
$b_idx      = $row['b_idx'];
$b_title    = $row['b_title'];
$b_content  = $row['b_content'];
$b_userid   = $row['b_userid']; // 글작성 아이디
$b_hit      = $row['b_hit'];
$b_regdate  = $row['b_regdate'];
$b_like     = $row['b_like'];
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글보기</title>
    <script>
        function like() {
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
                    alert('좋아요!');
                    document.getElementById("like").innerHTML = xhr.responseText;
                }
            }
            xhr.open("GET", "like_ok.php?b_idx=<?= $b_idx ?>", true);
            xhr.send();
        }
    </script>

</head>

<body>
    <h2>글보기</h2>
    <table border="1" width="800">
        <tr>
            <th>제목</th>
            <td><?= $b_title ?></td>
        </tr>
        <tr>
            <th>글쓴이</th>
            <td><?= $b_userid ?></td>
        </tr>
        <tr>
            <th>날짜</th>
            <td><?= $b_regdate ?></td>
        </tr>
        <tr>
            <th>조회수</th>
            <td><?= $b_hit ?></td>
        </tr>
        <tr>
            <th>좋아요</th>
            <td><span id="like"><?= $b_like ?></span></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><?= $b_content ?></td>
        </tr>
        <tr>
            <td colspan="2">
                <?php
                if ($id == $b_userid) {
                ?>
                    <a href="./edit.php?b_idx=<?= $b_idx ?>">수정</a>
                    <a href="./delete.php?b_idx=<?= $b_idx ?>">삭제</a>
                <?php
                }
                ?>
                <a href="./list.php">리스트</a>
                <img src="./images/like.png" width="20" onclick="like()">
            </td>
        </tr>
    </table>
    <hr />
    <form method="post" action="reply_ok.php">
        <input type="hidden" name="b_idx" value="<?= $b_idx ?>">
        <p><?= $id ?> : <input type="text" name="re_content"> <input type="submit" value="확인"></p>
    </form>
    <hr />
    <?php
    $sql = "select re_idx, re_userid, re_content, re_regdate from tb_reply where re_boardidx=$b_idx order by re_idx desc";
    $result = mysqli_query($conn, $sql);

    while ($row = mysqli_fetch_array($result)) {
        $re_idx     = $row['re_idx'];
        $re_userid  = $row['re_userid'];
        $re_content = $row['re_content'];
        $re_regdate = $row['re_regdate'];
    ?>
        <p><?= $re_userid ?> : <?= $re_content ?> (<?= $re_regdate ?>)</p>
    <?php
    }
    ?>
</body>

</html>