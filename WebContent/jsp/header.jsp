<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->
	<div class="container-fluid">
		<div class="col-md-4">
			<img src="${pageContext.request.contextPath}/img/logo2.png" />
		</div>
		<div class="col-md-5">
			<img src="${pageContext.request.contextPath}/img/header.png" />
		</div>
		<div class="col-md-3" style="padding-top: 20px">
			<ol class="list-inline">
				<c:if test="${empty user }">
					<li><a
						href="${pageContext.request.contextPath }/jsp/login.jsp">登录</a></li>
					<li><a
						href="${pageContext.request.contextPath }/jsp/register.jsp">注册</a></li>
					<li><a href="${pageContext.request.contextPath }/jsp/cart.jsp">购物车</a></li>
				</c:if>
				<c:if test="${not empty user }">
					<li><a href="#">欢迎，${user.username }</a></li>
					<li><a href="${pageContext.request.contextPath }/jsp/cart.jsp">购物车</a></li>
					<li><a
						href="${pageContext.request.contextPath }/userServlet?method=logout">注销</a></li>
				</c:if>
			</ol>
		</div>
	</div>
	<!--
            	时间：2015-12-30
            	描述：导航条
            -->
	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath }/indexServlet?method=findHotAndNew">首页</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="ulid">
					<!-- 导航条 -->
				</ul>
				<form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath }/productServlet" method="post">
					<input type="hidden" name="method" value="findByKeyword">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search" name="keyword">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
	</div>
</body>
<script type="text/javascript">
	var url = "${pageContext.request.contextPath}/categoryServlet";
	$.getJSON(url, {"method":"findCatecory"}, function(result){
		$(result).each(function(i, obj){
			$("#ulid").append("<li><a href='${pageContext.request.contextPath}/productServlet?method=findByCategoryIdAndPage&curPage=1&cid="+obj.cid+"'>"+obj.cname+"</a></li>");
		})
	})
</script>

</html>