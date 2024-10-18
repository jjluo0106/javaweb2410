<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
<!-- 利用 Bootstrap 的登入頁面 -->
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-4">
      <h3 class="text-center mt-5">Login</h3>
      <form id="loginForm" action="/dealLogin" method="POST">
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" required>
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
        </div>
        <div class="mb-3">
          <label for="captcha" class="form-label">Captcha</label>
          <div class="d-flex align-items-center">
            <input type="text" class="form-control" id="captcha" name="captcha" placeholder="Enter captcha" required>
            <img id="captchaImage" src="/captcha" alt="Captcha" class="ms-2" style="cursor: pointer; height: 50px;" onclick="refreshCaptcha()">
          </div>
        </div>
        <button type="submit" class="btn btn-primary w-100">Login</button>
      </form>

      <!-- Error message area -->

      <div class="text-center mt-3">
        <a href="#">Forgot password?</a>
      </div>
      <div id="errorMessage" class="text-center mt-3" style="color: red;"></div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
  function refreshCaptcha() {
    // 刷新驗證碼圖片
    document.getElementById('captchaImage').src = '/captcha?' + new Date().getTime();
  }

  // JavaScript 處理表單提交事件
  document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // 停止默認的表單提交，改用 JavaScript 提交

    const formData = new FormData(event.target);

    fetch('/dealLogin', {
      method: 'POST',
      body: formData,
    })
            .then(response => response.json())
            .then(data => {
              if (data.success) {
                document.getElementById('errorMessage').style.color = 'green';
                document.getElementById('errorMessage').textContent = 'Login success: ' + data.message;
                // 可以根據需求跳轉到另一頁
              } else {
                // Display error message in red in the specified area
                document.getElementById('errorMessage').textContent = 'Login failed: ' + data.message;
              }
            })
            .catch(error => {
              console.error('Error submitting login form:', error);
              document.getElementById('errorMessage').textContent = 'An unexpected error occurred.';
            });
  });
</script>
</body>
</html>
