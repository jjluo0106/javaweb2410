<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>主頁面</h1>

<button id="logoutBtn">退出</button>

<script>
    document.getElementById("logoutBtn").addEventListener("click", function() {
        fetch("/dealLogOut", {
            method: "Post"
        })
            .then(response => {
            if (response.ok) {

                location.reload();
                // 登出成功，跳轉到登入頁面
                // window.location.href = "/login";
            } else {
                alert("登出失敗");
            }
        });
    });
</script>


</body>
</html>