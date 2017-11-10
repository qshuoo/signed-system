<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css"
	rel="stylesheet" />

<!-- 可选的Bootstrap主题文件（一般不使用） -->

<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.css"
	rel="stylesheet" />
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/user.list.js"></script>
<title></title>
<style type="text/css" media="screen">
#pagination-digg li {
	border: 0;
	margin: 0;
	padding: 0;
	font-size: 11px;
	list-style: none;
	/* savers */
	float: left;
}

#pagination-digg a {
	border: solid 1px #9aafe5;
	margin-right: 2px;
}

#pagination-digg .previous-off, #pagination-digg .next-off {
	border: solid 1px #DEDEDE;
	color: #888888;
	display: block;
	float: left;
	font-weight: bold;
	margin-right: 2px;
	padding: 3px 4px;
}

#pagination-digg .next a, #pagination-digg .previous a {
	font-weight: bold;
}

#pagination-digg .active {
	background: #2e6ab1;
	color: #FFFFFF;
	font-weight: bold;
	display: block;
	float: left;
	padding: 4px 6px;
	/* savers */
	margin-right: 2px;
}

#pagination-digg a:link, #pagination-digg a:visited {
	color: #0e509e;
	display: block;
	float: left;
	padding: 3px 6px;
	text-decoration: none;
}

#pagination-digg a:hover {
	border: solid 1px #0e509e;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
}

h2 {
	clear: both;
	border: 0;
	margin: 0;
	padding-top: 30px;
	font-size: 13px;
}

p {
	border: 0;
	margin: 0;
	padding: 0;
	padding-bottom: 20px;
}

ul {
	border: 0;
	margin: 0;
	padding: 0;
}
</style>

</head>

<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h3>
					欢迎你:<span id="loginName">${loginUser.uname }</span>
				</h3>
				<shiro:hasAnyRoles name="employee,manager">
					<button class="btn btn-block btn-info" type="button"
						onclick="insertSign()">签到/打卡</button>
				</shiro:hasAnyRoles>
				<shiro:hasAnyRoles name="manager,root">
					<!-- 					<form id="searchForm" action="" method="get"> -->
					<input id="searchName" type="text" class="search"
						placeholder="根据员工名字插叙某一个员工的打卡记录">
					<input onclick="searchSign()" type="button" value="提交">
					<!-- 					</form> -->
				</shiro:hasAnyRoles>

				<table class="table table-bordered">
					<thead>
						<tr>
							<th>员工</th>
							<th>打卡时间</th>
							<th>状态</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="signMsg">
					</tbody>
				</table>

				<div style="float: right">
					第 <select id="listPage">
						<option value="1">1</option>
					</select> 页
				</div>

			</div>

		</div>
	</div>

</body>

</html>