<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<h1>主頁面</h1>

<button id="logoutBtn">退出</button>

<ul>
    <#list users as user>
        <li>${user.id} - ${user.name} - ${user.age}</li>
    </#list>
</ul>

<script>
    document.getElementById("logoutBtn").addEventListener("click", function() {
        fetch("/dealLogOut", {
            method: "POST"
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