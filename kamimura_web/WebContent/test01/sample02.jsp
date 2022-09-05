<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/kamimura_web/test01/css/style.css">
<title>java_postgerSQL管理メニュー(登録)</title>
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
	<p class="update_p">下記のデータを入力後登録を押してください。</p>
	<form action="/kamimura_web/Sample02" method="post" >
	<table>
	<tr>
	<th>商品ID</th>
	<td>
	<input type="text" size="10" name="shohin_id" placeholder="例：0001">
	</td>
	</tr>
	<tr>
	<th>商品名</th>
	<td>
	<input type="text" size="30" name="shohin_mei" placeholder="例：テーブル">
	</td>
	</tr>
	<tr>
	<th>商品分類</th>
	<td>
	<input type="text" size="20" name="shohin_bunrui" placeholder="例：事務用品">
	</td>
	</tr>
	<tr>
	<th>販売単価</th>
	<td>
	<input type="text" size="10" name="hanbai_tanka" placeholder="例：3000">
	</td>
	</tr>
	<tr>
	<th>仕入単価</th>
	<td>
	<input type="text" size="10" name="shiire_tanka" placeholder="例：2000">
	</td>
	</tr>
	<tr>
	<th>登録日</th>
	<td>
	<input type="text" size="20" name="torokubi" placeholder="例：2020-01-01">
	</td>
	</tr>
	<tr>
	<td class="in_bt">
	<input type="submit" name="submit" value="登録"  >
	<input type="reset" name="reset" value="リセット">
	</td>
	</tr>
	</table>
	</form>
</body>
</html>