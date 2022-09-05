<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sid = request.getAttribute("shohin_id")!=null?(String)request.getAttribute("shohin_id"):"";
	String sname = request.getAttribute("shohin_mei")!=null?(String)request.getAttribute("shohin_mei"):"";
	String sbunrui = request.getAttribute("shohin_bunrui")!=null?(String)request.getAttribute("shohin_bunrui"):"";;
	int shanbai = request.getAttribute("hanbai_tanka")!=null?Integer.parseInt((String)request.getAttribute("hanbai_tanka")):0;;
	int sshiire =  request.getAttribute("shiire_tanka")!=null?Integer.parseInt((String)request.getAttribute("shiire_tanka")):0;;;
	String storokubi = request.getAttribute("torokubi")!=null?(String)request.getAttribute("torokubi"):"";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/kamimura_web/test01/css/style.css">
<title>java_postgerSQL管理メニュー(更新)</title>
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
	<p class="up_p">最初に更新データを検索してください</p>
	<div class="up_kensaku">
	<form action="/kamimura_web/Sample03" method="post">
	<input type="text" name="kensaku" placeholder="例：0001">
	<input type="submit" name="submit" value="検索">
	</form>
	</div>
		<form action="/kamimura_web/Sample03" method="post" >
	<table>
	<tr>
	<th>商品ID</th>
	<td>
	<input type="text" size="10" name="shohin_id" placeholder="例：0001" readonly value=<%= sid %> >
	</td>
	</tr>
	<tr>
	<th>商品名</th>
	<td>
	<input type="text" size="30" name="shohin_mei" placeholder="例：テーブル" value=<%= sname %>>
	</td>
	</tr>
	<tr>
	<th>商品分類</th>
	<td>
	<input type="text" size="20" name="shohin_bunrui" placeholder="例：事務用品" value=<%= sbunrui %>>
	</td>
	</tr>
	<tr>
	<th>販売単価</th>
	<td>
	<input type="text" size="10" name="hanbai_tanka" placeholder="例：3000" value=<%= shanbai %>>
	</td>
	</tr>
	<tr>
	<th>仕入単価</th>
	<td>
	<input type="text" size="10" name="shiire_tanka" placeholder="例：2000" value=<%= sshiire %>>
	</td>
	</tr>
	<tr>
	<th>登録日</th>
	<td>
	<input type="text" size="20" name="torokubi" placeholder="例：2020-01-01" value=<%= storokubi %>>
	</td>
	</tr>
	<tr>
	<td class="up_bt">
	<input type="submit" name="submit" value="更新">
	<input type="reset" name="reset" value="リセット">
	</td>
	</tr>
	</table>
	</form>
</body>
</html>