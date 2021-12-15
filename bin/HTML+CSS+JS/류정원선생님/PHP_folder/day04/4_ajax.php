<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajax</title>
    <script>
        function sendRequest() {
            const xhr = new XMLHttpRequest();

            xhr.onreadystatechange = function() {
                if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
                    document.getElementById('text').innerHTML = xhr.responseText;
                }
            }
            xhr.open("GET", "4_ajax_ok.php?userid=apple&userpw=1111", true);
            xhr.send();

        }
    </script>
</head>

<body>
    <h2>Ajax</h2>
    <p><input type="button" onclick="sendRequest()" value="요청"></p>
    <p id="text"></p>
</body>

</html>