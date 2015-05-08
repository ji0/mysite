<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sds.icto.mysite.vo.MemberVO"%>
<%
	//HttpSession session = request.getSession(false);

	MemberVO authMember = (MemberVO) session.getAttribute("authMember");
%>



<h1>MySite</h1>
<ul>



<% if(authMember == null){
	%>	<li><a href="/mysite/member?a=loginform">로그인</a>


	<li><a href="/mysite/member?a=joinform">회원가입</a>

	<%} else{%>
	
	<li><a href="/mysite/member?a=uinfo">회원정보수정</a>
	<li><a href="/mysite/member?a=logout">로그아웃</a>
	<li><%=authMember.getName() %>님 안녕하세요 ^^;</li>
	<%} %>
</ul>