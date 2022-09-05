<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/kamimura_web/test01/css/style.css">
<title>java_postgerSQLデータ確認</title>
</head>
<body>
	<menu>
	<ul>
	<li><a href="http://localhost:8080/kamimura_web/test01/sample00.jsp"">トップ</a></li>
	<li><a href="http://localhost:8080/kamimura_web/Sample01">確認</a></li>
	<li><a href="http://localhost:8080/kamimura_web/test01/sample02.jsp">登録</a></li>
	<li><a href="http://localhost:8080/kamimura_web/test01/sample03.jsp">更新</a></li>
	<li><a href="http://localhost:8080/kamimura_web/test01/sample04.jsp">削除</a></li>
	</ul>
	</menu>
	<header>
	<h1>★★商品一覧表★★</h1>
	</header>
	<div>
	<table border="1">
	<tr>
	<th>商品番号</th><th>商品名</th><th>商品分類</th><th>販売単価</th><th>仕入単価</th><th>登録日</th>
	</tr>
	<%
	 Object obj = request.getAttribute("datas");
	 ArrayList<String[]>datas = (ArrayList)obj;
	 for(String[] data : datas){


	%>
	<tr>
	<td><%= data[0] %></td><td><%= data[1] %></td><td><%= data[2] %></td><td><%= data[3] %></td><td><%= data[4] %></td><td><%= data[5] %></td>
	</tr>
	<%
	}
	%>
	</table>
	</div>
</body>
</html>