<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
	<table align="center" cellpadding="3px">
		<tr style="background:#C98FED">
			<th>아이템 번호</th>
			<th>아이템 이름</th>
			<th>아이템 가격</th>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr style="background:#EDEDED">
				<td align="center">${item.itemid }</td>
				<td align="center"><a href="detail?itemid=${item.itemid }">${item.itemname }</a></td>
				<td align="center">${item.price }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>