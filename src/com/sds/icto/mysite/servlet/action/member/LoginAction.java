package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.MemberDAO;
import com.sds.icto.mysite.vo.MemberVO;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException,
			ServletException {
		// TODO Auto-generated method stub

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPassword(password);
		
		MemberDAO dao = new MemberDAO();
		MemberVO authMember =  dao.getMember(vo);
		
		//비번이나 이메일 에러
		if(authMember == null){
			response.sendRedirect("/mysite/member?a=loginform&result=fail");
			return;
		}
				
		//인증처리(로긴처리)
		HttpSession session = request.getSession(true);
		session.setAttribute("authMember", authMember);
		response.sendRedirect("/mysite/");

		
	}

}
