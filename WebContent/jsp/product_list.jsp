<%@page import="com.azhuang.service.impl.ProductServiceImpl"%>
<%@page import="com.azhuang.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="com.azhuang.utils.*"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>

	<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->

	<!--
            	时间：2015-12-30
            	描述：导航条
            -->
	<jsp:include page="head.jsp"></jsp:include>
	<%-- <%@include file="head.jsp" %> --%>
	<%
		//连接MySQL数据库   
		/* Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3306/news";
		String user = "root";
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement st = conn.createStatement(); */
	%>

	<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="#">首页</a></li>
			</ol>
		</div>
		<c:forEach items="${pb.list }" var="pro">
			<div class="col-md-2">
				<a
					href="${pageContext.request.contextPath }/product?method=findProductByID&pid=${pro.pid}">
					<img src="${pageContext.request.contextPath}/${pro.pimage}"
					width="170" height="170" style="display: inline-block;">
				</a>
				<p align="center">
					<a
						href="${pageContext.request.contextPath }/product?method=findProductByID&pid=${pro.pid}"
						style='color: green'>${fn:substring(pro.pname,0,8)}....</a>
				</p>
				<p align="center">
					<font color="#FF0000">商城价：&yen;${pro.market_price }</font>
				</p>
			</div>

		</c:forEach>



	</div>

	<!--分页 -->
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;"
		align="center">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">

			<!-- 	 判断是否是第一页  product?method=findByPage&cid="+this.cid+"&currPage=1'>"+this.cname+
 -->
			<c:if test="${pb.currPage ==1}">

				<li class="disabled"><a href="#" aria-label="Previous"><span
						aria-hidden="true">&laquo;</span></a></li>

			</c:if>

			<c:if test="${pb.currPage!=1 }">
				<li><a
					href="${pageContext.request.contextPath }/product?method=findPageBycid&cid=${param.cid}&currPage=${pb.currPage-1}"
					aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			</c:if>



			<!-- 	遍历页数 并且判断是否是当前页
					 product?method=findByPage&cid="+this.cid+"&currPage=1'>"+this.cname+
 -->
			<c:forEach begin="1" end="${pb.totalPage }" var="n">

				<c:if test="${pb.currPage==n }">
					<li class="active"><a href="javascript:void(0)">${n }</a></li>

				</c:if>
				<c:if test="${pb.currPage!=n }">
					<li><a
						href="${pageContext.request.contextPath }/product?method=findPageBycid&cid=${param.cid}&currPage=${n}">${n }</a></li>
				</c:if>
			</c:forEach>

			<c:if test="${pb.currPage!=pb.totalPage }">
				<li><a
					href="${pageContext.request.contextPath }/product?method=findPageBycid&cid=${param.cid}&currPage=${pb.currPage+1}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>

				</a></li>
			</c:if>
			<c:if test="${pb.currPage==pb.totalPage }">
				<li><a href="javascript:void(0)" aria-label="Next"> <span
						aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>

		</ul>
	</div>
	<!-- 分页结束=======================        -->

	<!--
       		商品浏览记录:
        -->
	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px"微软雅黑 ";">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>



		<div style="overflow: hidden;">

			<ul style="list-style: none;">

				<%-- 	<c:forEach items="" var="id" begin="1">  <c:set value="${ fn:split(string1, ',') }" var="str1" />
				</c:forEach> --%>

				<c:set value="${fn:split(cookie.ids.value, '-')}" var="str1" />
				<c:forEach items="${str1 }" var="s">
					<font>${ s }</font>


					<%
						//连接MySQL数据库   
							/* Class.forName("com.mysql.jdbc.Driver").newInstance();
							String url = "jdbc:mysql://localhost:3306/news";
							String user = "root";
							String password = "1234";
							Connection conn = DriverManager.getConnection(url, user, password);
							Statement st = conn.createStatement(); */

							ProductService ps = new ProductServiceImpl();
							// ps.findProductByID(s);
					%>


				</c:forEach>
				<li
					style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
					src="${pageContext.request.contextPath}/products/1/cs10001.jpg"
					width="130px" height="130px" /> <font>${cookie.ids.value}</font> <font>${ str1 }</font></li>




			</ul>

		</div>

	</div>
	<div style="margin-top: 50px;">
		<img src="${pageContext.request.contextPath}/image/footer.jpg"
			width="100%" height="78" alt="我们的优势" title="我们的优势" />
	</div>

	<div style="text-align: center; margin-top: 5px;">
		<ul class="list-inline">
			<li><a>关于我们</a></li>
			<li><a>联系我们</a></li>
			<li><a>招贤纳士</a></li>
			<li><a>法律声明</a></li>
			<li><a>友情链接</a></li>
			<li><a target="_blank">支付方式</a></li>
			<li><a target="_blank">配送方式</a></li>
			<li><a>服务声明</a></li>
			<li><a>广告声明</a></li>
		</ul>
	</div>
	<div style="text-align: center; margin-top: 5px; margin-bottom: 20px;">
		Copyright &copy; 2005-2016 传智商城 版权所有</div>

</body>
<script type="text/javascript">
	$(function() {
		var $str = $
		{
			cookie.ids.value
		}
		;
		//	alert($str);
	})
</script>
</html>