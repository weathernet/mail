<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
<link type="text/css" rel="stylesheet" href="css/css.css">
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/index.js"></script>
</head>
<body>主界面 欢迎用户: ${sessionScope.user.name}
<div class="box">
	<!-- 存放大图的容器-->
	<div class="all">
		<div class="top-img">
			<div class="activeimg">
				<img src="img/1.jpg">
				<img src="img/2.jpg">
				<img src="img/3.jpg">
				<img src="img/4.jpg">
				<img src="img/5.jpg">
			</div>
			<div class="left"><img src="img/left.png"> </div>
			<div class="right"><img src="img/right.png"></div>
		</div>
		<!-- 存放缩略图的容器-->
		<div class="bot-img">
			<ul>
				<li class="active"><img src="img/1.jpg"> </li>
				<li><img src="img/2.jpg"> </li>
				<li><img src="img/3.jpg"> </li>
				<li><img src="img/4.jpg"> </li>
				<li><img src="img/5.jpg"> </li>
			</ul>
		</div>
	</div>
</div>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">

</div>
</body>
</html>