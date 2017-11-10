<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="Cache" content="no-cache">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css"
	rel="stylesheet" />

<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.css"
	rel="stylesheet" />

<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.js"></script>

<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
<title></title>
</head>

<body>
	<div class="container" style="padding-top: 10%">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<h2 class="form-group" align="center">签到系统</h2>
			<form class="form-horizontal" action="login" method="post">
				<div class="form-group">
					<input id="inputEmail" placeholder="用户名" class="form-control"
						name="uname" type="text" />
				</div>
				<div class="form-group">
					<input id="inputPassword" placeholder="密码" class="form-control"
						name="upassword" type="password" />
				</div>
				<div class="form-group">
					<button class="btn btn-primary btn-block" type="submit">登录</button>
				</div>
			</form>
		</div>
	</div>
</body>

</html>