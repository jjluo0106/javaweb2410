<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
<#--利用boostrap的登錄頁面-->
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-4">
      <h3 class="text-center mt-5">Login</h3>
      <form>
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input type="text" class="form-control" id="username" placeholder="Enter username">
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" placeholder="Enter password">
        </div>
        <div class="mb-3">
          <label for="captcha" class="form-label">Captcha</label>
          <div class="d-flex align-items-center">
            <input type="text" class="form-control" id="captcha" placeholder="Enter captcha" required>
            <img id="captchaImage" src="/captcha" alt="Captcha" class="ms-2" style="cursor: pointer; height: 50px;" onclick="refreshCaptcha()">
          </div>
        </div>
        <button type="submit" class="btn btn-primary w-100">Login</button>
      </form>
      <div class="text-center mt-3">
        <a href="#">Forgot password?</a>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
  function refreshCaptcha() {
    // 刷新驗證碼圖片
    document.getElementById('captchaImage').src = '/captcha?' + new Date().getTime();
  }
</script>
</body>
</html>
