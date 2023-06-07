<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f3f3f3;
        }

        .login-form {
            margin-top: 100px;
            padding: 50px;
            background-color: #ffffff;
            box-shadow: 0px 0px 5px #cccccc;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 align="center" class="form-signin-heading">LOGIN</h2>
    <div class="row justify-content-sm-center">
        <div class="col-md-6 col-sm-8">
            <form class="login-form" action="/login" method="post">
                <div class="form-group">
                    <label for="inputEmail">Email address</label>
                    <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="userName">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" id="inputPassword"
                           placeholder="Password" name="passWord">
                </div><br/>
                <span class="alert-danger">${checkLogin==1?"Tai khoan haoc mat khau khong chinh xac!":""}</span>
                <center><button type="submit" class="btn btn-primary">Login</button>
                    <a href="/home" type="submit" class="btn btn-primary">CLose</a>
                </center>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
