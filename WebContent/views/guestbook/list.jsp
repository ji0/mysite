<%@ page contentType="text/html;charset=UTF-8"
	import="java.util.*, com.sds.icto.mysite.vo.GuestBookVO"%>
<%
	List<GuestBookVO> list = (List<GuestBookVO>) request
			.getAttribute("list");
%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/views/include/header.jsp" flush="false" />
		</div>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite/guestbook" method="post">
					<input type="hidden" name="a" value="insert">

					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="message" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<li>
						<%
							for (GuestBookVO vo : list) {
						%>
						<table>
							<td>[<%=vo.getNo()%>]
							</td>
							<td><%=vo.getName()%></td>
							<td><%=vo.getReg_date()%></td>


							<td><a
								href="/mysite/guestbook?a=deleteform&no=<%=vo.getNo()%>">삭제</a></td>

							</tr>
							<tr>
								<td colspan=4><%=vo.getMessage()%></td>
							</tr>
						</table> <br> <%
 	}
 %> <br>
					</li>
				</ul>
			</div>
		</div>
		<div id="navigation">
			<jsp:include page="/views/include/navigation.jsp" />
		</div>
		<div id="footer">
			<p>(c)opyright 2014</p>
		</div>
	</div>
</body>
</html>